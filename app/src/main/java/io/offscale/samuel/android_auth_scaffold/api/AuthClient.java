package io.offscale.samuel.android_auth_scaffold.api;

import android.content.Context;

import java.net.ConnectException;

import io.offscale.samuel.android_auth_scaffold.utils.BaseApiClient;
import io.offscale.samuel.android_auth_scaffold.utils.CachedReq;
import io.offscale.samuel.android_auth_scaffold.utils.IMimeTypes;
import okhttp3.Request;
import okhttp3.RequestBody;


public final class AuthClient extends BaseApiClient {
    private AuthClient(final Context context, final String hostname,
                       final CachedReq cache) throws ConnectException {
        super(context, hostname, cache);
    }

    public AuthClient(final Context context) throws ConnectException {
        this(context, null, null);
    }

    public final Request register(final String email, final String password) {
        return new Request.Builder()
                .url(getBaseUri() + "/user")
                .post(RequestBody.create(IMimeTypes.MEDIA_TYPE_JSON,
                        String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password)))
                .build();
    }

    public final Request login(final String email, final String password) {
        return new Request.Builder()
                .url(getBaseUri() + "/auth")
                .post(RequestBody.create(IMimeTypes.MEDIA_TYPE_JSON,
                        String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password)))
                .build();
    }
}
