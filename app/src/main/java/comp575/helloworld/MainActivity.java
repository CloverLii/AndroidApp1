package comp575.helloworld;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.Adapter;
import java.util.ArrayList;

import junit.framework.Assert;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private ArrayAdapter<Contact> adapter;
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup Adapter
        contactListView = findViewById(R.id.contactsListView);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contacts);

        //check device orientation
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            contactListView.setAdapter(adapter);

            // add some Contacts
            contacts.add(new Contact("Joe Bloggs", "joe@bloggs.co.nz", "021123456"));
            contacts.add(new Contact("Jane Doe", "jane@doe.co.nz", "022123456"));
        }
    }

    public void saveContact(View view) {
        EditText nameField = findViewById(R.id.name);
        String name = nameField.getText().toString();

        EditText emailField = findViewById(R.id.email);
        String email = emailField.getText().toString();

        EditText phoneField = findViewById(R.id.mobile);
        String phone = phoneField.getText().toString();

        Contact newContact = new Contact(name, email, phone);

        // check if new contact exists
        for (Contact c : contacts) {
            if (newContact.equals(c)) {
                Toast.makeText(this, name + "  already exists", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // add new contact
        contacts.add(newContact);

        // notify adapter change
        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}