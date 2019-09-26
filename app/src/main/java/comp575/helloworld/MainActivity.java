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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

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
            contactListView.setOnItemClickListener(this);

            // get saved contacts in portrait mode
            if (savedInstanceState != null) {
                for (Parcelable contact : savedInstanceState.getParcelableArrayList(
                        "contacts")) {
                    contacts.add((Contact) contact);
                }
            } else {
                contacts.add(new Contact("Joe Bloggs", "joe@bloggs.co.nz", "021123456"));
                contacts.add(new Contact("Jane Doe", "jane@doe.co.nz", "022123456"));
            }
        }
    }

    public void saveContact(View view) {

        // get input values
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
                System.out.println("******** contact has existed");
                Toast.makeText(this,  name +" exists, update the info ", Toast.LENGTH_SHORT).show();

                // update the info for exist contact
                c = newContact;
                System.out.println("******** update existed contact");
                return;
            }
        }
        // add new contact
        System.out.print("******** add new contact");
        contacts.add(newContact);
        Toast.makeText(this, " save new contact successfully", Toast.LENGTH_SHORT).show();


        // notify adapter change
        if(adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = (Contact) parent.getAdapter().getItem(position);
        Toast.makeText(parent.getContext(), "Clicked " + contact, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedState) {
        savedState.putParcelableArrayList("contacts", contacts);
        super.onSaveInstanceState(savedState);
    }
}