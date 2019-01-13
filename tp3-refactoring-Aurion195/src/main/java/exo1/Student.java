package exo1;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class Student 
{
	
	String name;
	Set<Grade> grades = new LinkedHashSet<Grade>();
	
	public Student(String name) 
	{
		this.name = name;
	}

	public void setGrades(Subject subject, double finalTestValue, double practicalWorkValue) 
	{
		Grade g = new Grade(subject, finalTestValue, practicalWorkValue);
		grades.add(g);
	}

	public String getGradesSheet() 
	{
		StringBuffer result = new StringBuffer();

		this.getSheetHaut(result);

		int ects = 0;
		double globalAverage = 0.0;

		for(Grade g : grades) 
		{
			this.getSheetMilieu(result, g);
			
			double average = g.getAverage(result) ;
			result.append(average+"\n");
			
			globalAverage += average;
			ects = this.getECTS(ects, g, average) ;
		}

		globalAverage /= grades.size();
		this.getSheetBas(result, globalAverage, ects);

		return result.toString();
	}
	
	public String getName()
	{
		return this.name ;
	}
	
	public int getECTS(int ects, Grade g, double average)
	{
		if(average > 10)
		{
			return (ects+g.getSubject().getCredits()) ;
		}
		
		return ects ;
	}
	
	public void getSheetHaut(StringBuffer result)
	{
		result.append("Name : " + name + "\n");
		result.append(String.format("%-16s", "\tSubject"));
		result.append(String.format("%-15s", "Final Test"));
		result.append(String.format("%-15s", "Practical"));
		result.append(String.format("%-16s", "Average\n"));
		result.append(String.format("%-15s", "------------"));
		result.append(String.format("%-15s", "------------"));
		result.append(String.format("%-15s", "------------"));
		result.append("------------\n");
	}
	
	public void getSheetBas(StringBuffer result, double globalAverage, int ects)
	{
		result.append("\nGlobal Average : " +String.format(Locale.US,"%.2f\n", globalAverage));
		result.append("Validated ECTS (European Credits Transfer Scale) : " + ects+ "\n");
	}

	public void getSheetMilieu(StringBuffer result, Grade g)
	{
		result.append("\t"+String.format("%-15s",g.getSubject().getName()));
		result.append(String.format("%-15s",g.getFinalTestValue()));
		result.append(String.format("%-15s",g.getPracticalWorkValue()));
	}
}
