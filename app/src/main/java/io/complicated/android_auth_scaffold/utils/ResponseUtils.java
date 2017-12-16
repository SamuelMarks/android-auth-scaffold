package io.complicated.android_auth_scaffold.utils;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

public final class ResponseUtils {
    public static String tryGetResponseStr(final Response response) {
        final ResponseBody body = response.body();
        if (body != null)
            try {
                return body.string();
            } catch (IOException e) {
                return "";
            } finally {
                body.close();
            }
        return "";
    }
}
