import java.util.Scanner;
import java.io.*;
/*
 * @author: Batuhan Kir
 * @version: 2020.05.05
 */
public class Driver
{
    /**
     * Starts the program and gives directions to user.
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        System.out.println("Select from the following menu: ");
        System.out.println("0. Exit the program.");
        System.out.println("1. Add an event.");
        System.out.println("2. Delete an event.");
        System.out.println("3. Delete all events on a specified day.");
        System.out.println("4. Display content of Calendar.");
        System.out.println("5. Search for an event.");

        EventList newList = new EventList();
        do
        {
            System.out.println();
            System.out.print("Make your menu selection now: ");

            int menuChoice = sc.nextInt();
            System.out.print(menuChoice);

            if(sc.hasNextLine())
            {
            	sc.nextLine();
            }
            switch(menuChoice)
            {
            case 0:
                System.out.println();
                System.out.println("Exiting program...good bye");
                done = true;
                break;
            case 1:
                System.out.println();
                System.out.print("You are now adding a new event to your Calendar.");
                int end = 0;
                while(end != -1)
                {
                    System.out.println();
                    System.out.print("\tEnter the name of the event: ");
                    String name = sc.nextLine();
                    System.out.print(name);
                    System.out.println();
                    if(newList.stringNameExists(name))
                    {
                        System.out.print("Event \"" + name + "\" already exists. Enter a different event name!");
                    }
                    else
                    {
                        System.out.print("\tEnter day of event: ");
                        int day = sc.nextInt();
                        System.out.print(day);
                        System.out.println();

                        System.out.print("\tEnter month of event: ");
                        String month = sc.next();
                        System.out.print(month);
                        System.out.println();

                        System.out.print("\tEnter year of event: ");
                        int year = sc.nextInt();
                        System.out.print(year);
                        System.out.println();

                        newList.addEvent(new Calender(name, day, month, year));
                        System.out.println("Event \"" + name + "\" has been registered for " + day + " " + month + " " +
 year + ".");
                        end = -1;
                    }
                }
                break;
            case 2:
                System.out.println();
                if(newList.emptyList() == false)
                {
                    System.out.println("You are now deleting an event from your Calendar.");
                    System.out.print("Name of event to delete: ");
                    String eventString = sc.nextLine();
                    System.out.print(eventString);
                    newList.removeEventByName(eventString);
                }
                else
                {
                    System.out.println("There are no events to delete in the Calendar.");
                }
                break;
            case 3:
                System.out.println();
                if(newList.emptyList() == false)
                {
                    System.out.println("You are now deleting all events for a specified day.");

                    System.out.print("\tEnter day of event: ");
                    int dayRemove = sc.nextInt();
                    System.out.print(dayRemove);
                    System.out.println();

                    System.out.print("\tEnter month of event: ");
                    String monthRemove = sc.next();
                    System.out.print(monthRemove);
                    System.out.println();

                    System.out.print("\tEnter year of event: ");
                    int yearRemove = sc.nextInt();
                    System.out.print(yearRemove);
                    System.out.println();
                    //newList.removeEventByDay(dayRemove, monthRemove, yearRemove);

                    System.out.print("\tShould any yearly events be deleted also?(Y/N): ");
                    String answer = sc.next();
                    System.out.print(answer);
                    System.out.println();
                    newList.removeEventByDay(answer, dayRemove, monthRemove, yearRemove);
                }
                else
                {
                    System.out.println("There are no events to delete in the Calendar.");
                }

                break;
            case 4:
                System.out.println();
                newList.displayEvents();
                break;
            case 5:
                System.out.println();
                if(newList.emptyList() == false)
                {
                    System.out.println("You are now searching for an event.");
                    System.out.print("\tEnter the name of the event to search for: ");
                    String nameSearch = sc.nextLine();
                    System.out.print(nameSearch);
                    System.out.println();
                    newList.displayInfoByName(nameSearch);
                }
                else
                {
                    System.out.println("There are no events in the Calendar.");
                }
                break;
            default:
                System.out.println("Invalid menu choice.");
            }
        }
        while(!done);
        sc.close();
    }

}
