package io.complicated.android_auth_scaffold.api.contact;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.mock.MockContext;

import org.junit.Test;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class ContactsClientUnitTest {

    @Test
    public void getContactsUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        MockContext mockContext = new MockContext();

        ContactsClient contactsClient = new ContactsClient(mockContext, "");

        String baseUri = contactsClient.getBaseUri();

        HttpUrl baseUrl = server.url(baseUri);

        contactsClient.getSync();

        RecordedRequest request = server.takeRequest();
        assertEquals("/contacts", request.getPath());
        assertNotNull(request.getHeader("Authorization"));

    }


}
