import java.util.Scanner;


public class ListImplementer
{
    public static void displayOptions()
    {
        System.out.println("1.) Add item");
        System.out.println("2.) Remove item");
        System.out.println("3.) Reverse list");
        System.out.println("4.) Exit program\n");
    }//displayOptions()

    public static String userInput(String displayOutput)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(displayOutput);
        String option = scanner.nextLine();
        return option;
    }//userInput()

    public static boolean options(String option, ListReferencedBased list)
    {
        boolean isFinished = false;
        int optionInt = Integer.parseInt(option);
        switch (optionInt)
        {
            case 1:
                //Add item
                addOrRemoveItem(list, 1);
                break;
            case 2:
                //Remove item
                addOrRemoveItem(list, 0);
                break;
            case 3:
                //Reverse list
                list.reverseList();
                displayList(list);
                break;
            case 4:
                //Exit program
                isFinished = true;
                break;
            default:
                System.out.println("Invalid option. Please choose an option from 1 to 4");
                break;
        }
        return isFinished;
    }//options()

    public static void addOrRemoveItem(ListReferencedBased list, int removeOrAdd)
    {
        String positionString = userInput("Enter position: ");
        int position = ((Integer.parseInt(positionString))-1); //make the integer n-1
        if(position < 0)
        {
            System.out.println("Invalid position. Must be 1 or more");

        }
        else
        {
            if(position > list.size())
            {
                System.out.println("Invalid position. Must be the size of the list or less");
            }
            else
            {
                if(removeOrAdd == 0)
                {
                    //Remove
                    list.remove(position);
                    displayList(list);
                }
                else
                {
                    //Add
                    list.add(position, userInput("Enter item to add: "));
                    displayList(list);
                }
            }
        }

    }//addOrRemoveItem()

    public static void displayList(ListReferencedBased list)
    {
        System.out.println("List: "+list);
        String sortStatus = (list.isSorted())? "List is in sorted order": "List is not in sorted order";
        System.out.println(sortStatus+"\n");
    }//displayList()

    public static void main(String...args)
    {
        boolean finished = false;
        ListReferencedBased list = new ListReferencedBased();
        while(!finished)
        {
            displayOptions();
            finished = options(userInput("\"Enter your choice (1-4): \""), list);
        }
        System.out.println("\nGoodbye!");
    }//main()
}//class()

