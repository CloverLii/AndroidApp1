package comp575.helloworld;

import android.arch.lifecycle.ViewModelStoreOwner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveContact(View view){
        //Toast.makeText(this, "Save contact clicked", Toast.LENGTH_SHORT).show();

        EditText nameField = (EditText) findViewById(R.id.name);
        String name = nameField.getText().toString();

        EditText mobileField = (EditText) findViewById(R.id.mobile);
        String  mobile = mobileField.getText().toString();

        EditText emailField = (EditText) findViewById(R.id.email);
        String email = emailField.getText().toString();

        Toast.makeText(this, "Saved contact for "+ name + email + mobile, Toast.LENGTH_SHORT).show();
    }
}
