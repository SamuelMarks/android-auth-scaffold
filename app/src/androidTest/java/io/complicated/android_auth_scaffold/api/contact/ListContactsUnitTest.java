package io.complicated.android_auth_scaffold.api.contact;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListContactsUnitTest {

    @Test
    public void listContactsToString() throws Exception {

        Contact contact1 = new Contact("John", "john@email.com", "Bob" );
        Contact contact2 = new Contact("Fred", "fred@email.com", "Bob" );

        Contact[] contacts = new Contact[2];
        contacts[0] = contact1;
        contacts[1] = contact2;

        ListContacts listContacts = new ListContacts("Bob", contacts);

        String expected = "ListContacts{owner Bob, contacts: [" +
                "Contact{\"name\": \"John\", \"email\": \"john@email.com\", \"owner\": \"Bob\"}, " +
                "Contact{\"name\": \"Fred\", \"email\": \"fred@email.com\", \"owner\": \"Bob\"}]}";

        assertEquals(expected, listContacts.toString());
    }
}
