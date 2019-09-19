package comp575.helloworld;


import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{
    public String name;
    public String email;
    public String mobile;

    public Contact(String name, String email, String mobile) {
        System.out.println(" ******** create Contact with default para");
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Contact(Parcel in) {
        System.out.println(" ******** create Contact with parcel object");
        name = in.readString();
        email = in.readString();
        mobile = in.readString();
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Contact oldContact = (Contact)obj;
        return this.name.equals(oldContact.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(mobile);
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }
        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
