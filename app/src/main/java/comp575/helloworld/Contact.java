package comp575.helloworld;

import android.os.Parcelable;

public class Contact {
    public String name;
    public String email;
    public String mobile;

    public Contact(String name, String email, String mobile)
    {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public String toString()
    {
        return name;
    }
}
