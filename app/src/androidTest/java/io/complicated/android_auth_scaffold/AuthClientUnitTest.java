package io.complicated.android_auth_scaffold;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.mock.MockContext;

import org.junit.Test;

import io.complicated.android_auth_scaffold.api.AuthClient;
import io.complicated.android_auth_scaffold.api.contact.ContactsClient;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AuthClientUnitTest {

    @Test
    public void loginUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        MockContext mockContext = new MockContext();

        AuthClient authClient = new AuthClient(mockContext);

        String baseUri = authClient.getBaseUri();

        server.url(baseUri);

        authClient.login("", "");

        RecordedRequest request = server.takeRequest();
        assertEquals("/login", request.getPath());

    }

    @Test
    public void registerUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        MockContext mockContext = new MockContext();

        AuthClient authClient = new AuthClient(mockContext);

        String baseUri = authClient.getBaseUri();

        server.url(baseUri);

        authClient.login("", "");

        RecordedRequest request = server.takeRequest();
        assertEquals("/register", request.getPath());

    }
}
