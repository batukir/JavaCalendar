
public class Calender
{
	private String event;
	private int day;
	private String month;
	private int year;
	public Calender(String event, int day, String month, int year)
	{
		setCalenderDetails(event, day, month, year);
	}
    public String getEvent() 
    {
		return event;
	}
	public void setEvent(String event) 
	{
		this.event = event;
	}
	public int getDay() 
	{
		return day;
	}
	public void setDay(int day)
	{
		this.day = day;
	}
	public String getMonth() 
	{
		return month;
	}
	public void setMonth(String month)
	{
		this.month = month;
	}
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	private void setCalenderDetails(String event, int day, String month, int year)
    {
		this.event = event;
		if(day > 0 && day < 31)
		{
			this.day = day;
		}
		else
		{
			System.out.println("Please enter valid day.");
		}
		if((month.equals("January") ||
		   month.equalsIgnoreCase("February") ||
		   month.equalsIgnoreCase("March") ||
		   month.equalsIgnoreCase("April") ||
		   month.equalsIgnoreCase("May") ||	
		   month.equalsIgnoreCase("June") ||	
		   month.equalsIgnoreCase("July") ||
		   month.equalsIgnoreCase("August") ||
		   month.equalsIgnoreCase("September") ||
		   month.equalsIgnoreCase("October") ||
		   month.equalsIgnoreCase("November") ||
		   month.equalsIgnoreCase("December")))
		{
			this.month = month;
		}
		else
		{
			System.out.println("Please enter valid month.");
		}
		if(year >= 0)
		{
			this.year = year;
		}
		else
		{
			System.out.println("Please enter valid year.");
		}
    }
    public void display()
    {
    	if(year == 0)
    	{
    		String yearString = String.valueOf(year);
    		yearString = " of every year.";
    		System.out.print("Event \"" + event + "\" is on " + month + " " + day + yearString);
    	}
    	else
    	{
    		System.out.print("Event \"" + event + "\" is on " + month + " " + day + ", " + year + ".");
    	}
    }

}
