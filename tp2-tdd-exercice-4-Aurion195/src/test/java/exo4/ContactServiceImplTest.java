package exo4;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class ContactServiceImplTest 
{
	Contact cTest;
	ContactDAO contactDAOTest;
	ContactServiceImpl csi ;
	
	@Before
	public void initialize()
	{
		this.cTest = mock(Contact.class);
		this.contactDAOTest =mock(ContactDAO.class);
		this.csi =  new ContactServiceImpl(this.contactDAOTest);
	}
	
	@Test
	public void shoulReturnMatchingWhenGetById()
	{
		try {
			this.cTest = this.contactDAOTest.getById(2);
			assertTrue(this.cTest == this.csi.getById(2));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			fail() ;
		}
	}
		
	@Test
	public void shouldReturnNullWhenGetByIdOnContactNotFound()
	{
		try {
			this.cTest = this.contactDAOTest.getById(10);
			assertTrue(this.cTest == null);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			fail() ;
		}
	}
	
	@Test
	public void shouldReturnContactsMatchingSearchStringWhenSearchBy()
	{
		ArrayList<Contact> c=new ArrayList<Contact>();
		c.add(ContactBuilder.JESSIE_JAMES);
		c.add(ContactBuilder.JESSIE_KISSINGER);
		c.add(ContactBuilder.AMY_KISSINGER);
		
		try {
			when(this.contactDAOTest.getByMatchingString("SSI")).thenReturn(c);
			assertTrue(c == this.csi.searchBy("SSI"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			fail() ;
		}
	}
	
	@Test
	public void shouldReturnContactWhenGetByMatchingString()
	{
		fail("Not yet implemented") ;
	}
	
	@Test
	public void shouldCreateContact()
	{
		try {
			ArgumentCaptor<Contact> argCapture = ArgumentCaptor.forClass(Contact.class) ;
			this.csi.createContact("Thomas", "Mathieu") ;
			verify(this.contactDAOTest).createContact(argCapture.capture());
			
			Contact test0 = new Contact(0,"Thomas", "Mathieu");
			Contact test1 = argCapture.getValue() ;
			
			assertTrue(this.csi.verifyContact(test0, test1) == true) ;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			fail("Not yet implemented") ;
		}
	}
	
	@Test(expected=DuplicatedContactException.class)
	public void shouldThrowDuplicateExceptionWhenCreateDuplicateContact() throws DuplicatedContactException
	{
		doThrow(new DuplicatedContactException()).when(this.contactDAOTest).createContact(Mockito.any());
		this.csi.createContact("Jessie", "James");
	}	
}
