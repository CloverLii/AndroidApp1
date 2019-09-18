package comp575.helloworld;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private ArrayAdapter<Contact> adapter;
    private ListView contactListview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup adapter
        contactListview = (ListView)findViewById(R.id.contactsListView);

        adapter = new ArrayAdapter<Contact>(this, android.R.layout.simple_list_item_1,contacts);

        // contactsListView does not exist in portrait view
        if(contactListview != null){
            contactListview.setAdapter(adapter);
            contactListview.setOnItemClickListener(this);

            // Add some contacts
            contacts.add(new Contact("Joe Bloggs", "joe@bloggs.co.nz", "021123456"));
            contacts.add(new Contact("Jane Doe", "jane@doe.co.nz", "022123456"));
        }

    }

    public void saveContact(View view){
        //Toast.makeText(this, "Save contact clicked", Toast.LENGTH_SHORT).show();

        EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();

        EditText mobileField = (EditText) findViewById(R.id.mobile);
        String  mobile = mobileField.getText().toString();

        EditText emailField = (EditText) findViewById(R.id.email);
        String email = emailField.getText().toString();

        contacts.add(new Contact(name, email, mobile));
        //Toast.makeText(this, "Saved contact for "+ name + email + mobile, Toast.LENGTH_SHORT).show();
    }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Contact contact = (Contact) parent.getAdapter().getItem(position);
            Toast.makeText(parent.getContext(), "Clicked " + contact,
                    Toast.LENGTH_SHORT).show();
            //contacts.add(contact);
        }
}
