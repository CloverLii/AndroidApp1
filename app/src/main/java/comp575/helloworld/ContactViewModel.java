package comp575.helloworld;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private ContactRepository contactRepository;
    private LiveData<List<Contact>> allContacts;

    public ContactViewModel (Application application){
        super(application);
        contactRepository = new ContactRepository(application);
        allContacts = contactRepository.getAllContacts();
    }

   public LiveData<List<Contact>> getAllContacts(){
        return allContacts;
    }

    public void insert(Contact contact){
        this.contactRepository.insert(contact);
    }

    public void update(Contact contact){
        this.contactRepository.update(contact);
    }

    public void delete(Contact contact){
        this.contactRepository.delete(contact);
    }
}
