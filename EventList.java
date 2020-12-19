
import java.util.ArrayList;
import java.util.Iterator;
/*
 * @author: Batuhan Kir
 * @version: 2020.05.05
 */
public class EventList
{
	private ArrayList<Calender> eventList;
	public EventList()
	{
		eventList = new ArrayList<Calender>();
	}
	public void addEvent(Calender c)
	{
		eventList.add(c);
	}
	public void removeEventByName(String name)
	{
		Iterator<Calender> it = eventList.iterator();
		boolean found = false;
		while(!found && it.hasNext())
		{
			Calender event = it.next();
			if(event.getEvent().equals(name))
			{
				found = true;
				System.out.println("Event \"" + event.getEvent() + "\" has been deleted from the Calendar");
				it.remove();
			}
		}
		if(!found)
		{
			System.out.println("No event with this name in the Calendar!");
		}
	}
	public void removeEventByDay(String answer ,int day, String month, int year)
	{
			if(answer.equalsIgnoreCase("Y"))
			{
				Iterator<Calender> it = eventList.iterator();
				boolean found = false;
				while(it.hasNext())
				{
					Calender event = it.next();
					if(event.getDay() == day && event.getMonth().equals(month) && (event.getYear() == year || event.getYear() == 0))
					{
						found = true;
						it.remove();
						//System.out.println("Events on " + month + " " + day + ", " + year + " including yearly have been deleted from the Calendar." );
					}
				}
				if(!found)
				{
					System.out.println("There are no events on " + month + " " + day + ", " + year);
				}
				else
				{
					System.out.println("Events on " + month + " " + day + ", " + year + " including yearly have been deleted from the Calendar." );
				}
			}
			else if(answer.equalsIgnoreCase("N"))
			{
				Iterator<Calender> it = eventList.iterator();
				boolean found = false;
				while(it.hasNext())
				{
					Calender event = it.next();
					if(event.getDay() == day && event.getMonth().equals(month) && event.getYear() == year)
					{
						found = true;
						it.remove();
					}
				}
				if(!found)
				{
					System.out.println("There are no events on " + month + " " + day + ", " + year);
				}
				else
				{
					System.out.println("Events on " + month + " " + day + ", " + year + " excluding yearly have been deleted from the Calendar." );
				}
			}
	}

	public void displayInfoByName(String name)
	{
		if(!eventList.isEmpty())
		{	
			Iterator<Calender> it = eventList.iterator();
			boolean found = false;
			while(!found && it.hasNext())
			{
				Calender event = it.next();
				if(event.getEvent().equals(name))
				{
					found = true;
			    	if(event.getYear() == 0)
			    	{
			    		String yearString = String.valueOf(event.getYear());
			    		yearString = " of every year.";
			    		System.out.println("Event \"" + event.getEvent() + "\" is on " + event.getMonth() + " " + event.getDay() + yearString);
			    	}
			    	else
			    	{
			    		System.out.println("Event \"" + event.getEvent() + "\" is on " + event.getMonth() + " " + event.getDay() + ", " + event.getYear() + ".");
			    	}
				}
			}
			if(!found)
			{
				System.out.println("Event \"" + name + "\" is not on calendar.");
			}
		}
	}
	public void displayEvents()
	{
		if(!eventList.isEmpty())
		{
			System.out.println("Your Calendar has the following " + eventList.size() + " elements:");
			for(Calender c: eventList)
			{
				c.display();
				System.out.println();
			}
		}
		else
		{
			System.out.println("Your Calendar has no registered events.");
		}
	}
	public boolean stringNameExists(String name)
	{
		//System.out.println("Event " + name + "already exists. Enter a different event name!");

		Iterator<Calender> it = eventList.iterator();
		boolean found = false;
		while(!found && it.hasNext())
		{
			Calender event = it.next();
			if(event.getEvent().equals(name))
			{
				found = true;
				//System.out.println("Event " + event.getEvent() + " already exists. Enter a different event name!");
				return true;
			}
		}
		return false;
	}
	public boolean emptyList()
	{
		boolean ans = eventList.isEmpty();
		if(ans == true)
		{
			return true;
		}
		return false;
	}
}
