package exo4;

import java.util.ArrayList;
import java.util.Collection;

public class ContactServiceImpl implements ContactService
{
	ContactDAO c ;
	ArrayList<Contact> contact =new ArrayList<Contact>();
	
	ContactServiceImpl(ContactDAO contact)
	{
		this.c = contact ;
	}
	
	public boolean verifyContact(Contact contact0, Contact contact1)
	{
		if(contact0  != null && contact1!= null)
		{
			if(contact0.getId() == contact1.getId() &&
			   contact0.getFirstName() == contact1.getFirstName() &&
			   contact0.getLastName() == contact1.getLastName())
			{
				return true ;
			}
		}
		
		return false ;
	}
	
	@Override
	public Collection<Contact> searchBy(String searchString) 
	{
		try
		{
			return c.getByMatchingString(searchString);
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Collection<Contact> listAllContacts() 
	{
		try {
			this.contact.add(ContactBuilder.AMY_JAMES);
			this.contact.add(ContactBuilder.AMY_KISSINGER);
			this.contact.add(ContactBuilder.JESSIE_JAMES);
			this.contact.add(ContactBuilder.JESSIE_KISSINGER);
			
			return this.contact;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null ;
		}
	}

	@Override
	public Contact getById(int contactId) 
	{
		try
		{
			return c.getById(contactId) ;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public Contact createContact(String firstName, String lastName) throws DuplicatedContactException 
	{
		Contact c = new Contact(this.c.nextID(), firstName, lastName) ;
		this.c.createContact(c);
		return c ;
	}

}
