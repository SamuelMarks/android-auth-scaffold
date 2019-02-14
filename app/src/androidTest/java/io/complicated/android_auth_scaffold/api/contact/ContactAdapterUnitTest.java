package io.complicated.android_auth_scaffold.api.contact;

import android.test.mock.MockContext;
import android.view.View;
import android.view.ViewGroup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ContactAdapterUnitTest {

    //TODO: Fix/Understand android viewgroup
    @Test
    public void getViewTest() throws Exception {

        MockContext mockContext = new MockContext();

        Contact contact1 = new Contact("John", "john@email.com", "Bob" );
        Contact contact2 = new Contact("Fred", "fred@email.com", "Bob" );

        Contact[] contacts = new Contact[2];
        contacts[0] = contact1;
        contacts[1] = contact2;

        ContactAdapter contactAdapter = new ContactAdapter(mockContext, contacts);

        View view = contactAdapter.getView(0, null, null);

        assertNotNull(view);



    }

}
