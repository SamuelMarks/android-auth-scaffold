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


public class ContactClientUnitTest {

    @Test
    public void getContactUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        MockContext mockContext = new MockContext();

        ContactClient contactClient = new ContactClient(mockContext);

        String baseUri = contactClient.getBaseUri();

        HttpUrl baseUrl = server.url(baseUri);

        Contact contact = new Contact("John", "john@email.com", "Bob" );

        contactClient.getSync(contact);

        RecordedRequest request = server.takeRequest();
        assertEquals(contact.getEmail(), request.getPath());
        assertNotNull(request.getHeader("Authorization"));

    }

    @Test
    public void putContactUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        Context appContext = InstrumentationRegistry.getTargetContext();

        ContactClient contactClient = new ContactClient(appContext);

        String baseUri = contactClient.getBaseUri();

        HttpUrl baseUrl = server.url(baseUri);

        Contact oldContact = new Contact("John", "john@email.com", "Bob" );

        Contact newContact = new Contact("John2", "john2@email.com", "Bob" );

        contactClient.putSync(oldContact, newContact);

        RecordedRequest request = server.takeRequest();
        assertEquals(oldContact.getEmail(), request.getPath());
        assertNotNull(request.getHeader("Authorization"));

    }

    @Test
    public void delContactUnitTest() throws Exception {

        MockWebServer server = new MockWebServer();

        server.enqueue(new MockResponse());

        server.start();

        Context appContext = InstrumentationRegistry.getTargetContext();

        ContactClient contactClient = new ContactClient(appContext);

        String baseUri = contactClient.getBaseUri();

        HttpUrl baseUrl = server.url(baseUri);

        Contact oldContact = new Contact("John", "john@email.com", "Bob" );

        contactClient.delSync(oldContact);

        RecordedRequest request = server.takeRequest();
        assertEquals(oldContact.getEmail(), request.getPath());
        assertNotNull(request.getHeader("Authorization"));

    }
}
