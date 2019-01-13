package exo1;

public class Grade 
{
	Subject subject;
	double finalTestValue, practicalWorkValue;
	
	public Grade(Subject subject, double finalTestValue, double practicalWorkValue) 
	{
		this.subject = subject;
		this.finalTestValue = finalTestValue;
		this.practicalWorkValue = practicalWorkValue;
	}

	public double getFinalTestValue() 
	{
		return finalTestValue;
	}

	public double getPracticalWorkValue() 
	{
		return practicalWorkValue;
	}

	public  Subject getSubject() 
	{
		return subject;
	}

	public double getAverage(StringBuffer result)
	{
		double average = 0 ;
		switch (this.getSubject().getDiscipline()) 
		{
			case Sport :
				average = 0.15*this.getFinalTestValue() + 0.85*this.getPracticalWorkValue();
				break;
			case Languages :
				average = 0.25*this.getFinalTestValue() + 0.75*this.getPracticalWorkValue();
				break;
			case CoSci :
				average = (this.getFinalTestValue()+ this.getPracticalWorkValue())/2;
				break;
		}
		
		return average ;
	}
}
