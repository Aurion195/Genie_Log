package exo1;

public class Subject 
{	
	enum Discipline { Sport, Languages, CoSci } ;

	String name;
	Discipline discipline;
	int ects;
	
	public Subject(String name,  Discipline discipline, int ects) 
	{
		this.name = name;
		this.discipline = discipline;
		this.ects = ects;
	}

	public int getCredits() 
	{
		return ects;
	}

	public Discipline getDiscipline() 
	{
		return discipline;
	}

	public String getName() 
	{
		return name;
	}
}
