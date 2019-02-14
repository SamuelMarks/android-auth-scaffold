package io.complicated.android_auth_scaffold.api.contact;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactUnitTest {

    @Test
    public void contactToString() throws Exception {

        Contact contact = new Contact("John", "john@email.com", "Bob" );
        String contactString = new String("Contact{\"name\": \"John\", \"email\": \"john@email.com\", \"owner\": \"Bob\"}");

        assertEquals(contact.toString(), contactString);
    }

    @Test
    public void contactFromString() throws Exception {

        Contact contact = new Contact("John", "john@email.com", "Bob" );
        String contactString = new String("Contact{\"name\": \"John\", \"email\": \"john@email.com\", \"owner\": \"Bob\"}");

        assertEquals(contact, Contact.fromString(contactString));
    }


}