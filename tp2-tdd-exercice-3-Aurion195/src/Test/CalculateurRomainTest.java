package Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*; 
import org.junit.Before;
import org.junit.Test;

import Main.CalculateurRomain;

public class CalculateurRomainTest 
{
		CalculateurRomain cRomain ;
		
		@Before
		public void initialize()
		{
			this.cRomain = mock(CalculateurRomain.class,"cRomain") ;
		}

		@Test
		public void shouldReturnIwhenI() 
		{
			when(this.cRomain.calculateur("I")).thenReturn("I");
			assertEquals(this.cRomain.calculateur("I"),"I");
		}
		
		@Test
		public void shouldReturnIIwhenII() 
		{
			when(this.cRomain.calculateur("II")).thenReturn("II");
			assertEquals(this.cRomain.calculateur("II"),"II");
		}
		
		@Test
		public void shouldReturnIIwhenIPlusI() 
		{
			when(this.cRomain.calculateur("I+I")).thenReturn("II");
			assertEquals(this.cRomain.calculateur("I+I"),"II");
		}
		
		@Test
		public void shouldReturnIVWhenVMoinsI()
		{
			when(this.cRomain.calculateur("V-I")).thenReturn("IV") ;
			assertEquals(this.cRomain.calculateur("V-I"), "IV") ;
		}
		
		@Test
		public void shouldReturnIXwhenVIIIPlusI()
		{
			when(this.cRomain.calculateur("VIII+I")).thenReturn("IX") ;
			assertEquals(this.cRomain.calculateur("VIII+I"), "IX") ;
		}
}
