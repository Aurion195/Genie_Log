package exo1;

import static org.junit.Assert.*;

import org.junit.*;

import exo1.Subject.Discipline;

public class StudentTest 
{
	Student student ;
	
	@Before
	public void initialize()
	{
		this.student = new Student("Thomas") ;
	}

	@Test
	public void shouldReturnName()
	{
		assertTrue(this.student.getName().equals("Thomas")) ;
	}
	
	@Test
	public void shouldReturnGrade()
	{
		this.student.setGrades(new Subject("Volley-Ball", Discipline.Sport, 2), 18, 2);
		assertTrue(this.student.getGradesSheet().contains("Volley-Ball")) ;
	}
	
	/**
	 * Le test est faux je ne comprend pas pourquoi, je dois mettre tromper dans un " "
	 * je pense
	 */
	@Test
	public void shouldReturnGradeSheet()
	{
		this.student.setGrades(new Subject("Volley-Ball", Discipline.Sport, 2), 18, 20);

		String exemple = "Name : Thomas\n" +
				"	Subject        Final Test     Practical      Average\n" +
		        "	------------   ------------   ------------   ------------\n"+
		        "	Volley-Ball    18.0           20.0           19.7\n"+
		        "\nGlobal Average : 19.70\n" +
		        "Validated ECTS (European Credits Transfer Scale) : 2\n" ;
		
		assertTrue(this.student.getGradesSheet().equals(exemple));
	}
}

