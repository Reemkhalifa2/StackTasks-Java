import java.util.Iterator;
import java.util.Stack;
public class EmployeeStackSearch {
    public static void main(String[] args) {
        Stack<String> empActions = new Stack<>();
        //Add at least 5 employee action records using the push() method
        empActions.push("Start work");
        empActions.push("Meeting");
        empActions.push("Lunch Break");
        empActions.push("Writing report");
        empActions.push("leave work");

        //Display the current stack with their positions from top
        for(String action : empActions){
            Integer position =  empActions.search(action);
            System.out.println(action+ " : "+ position);
        }

        //Use search() to find the position of 2 different employee actions
        System.out.println("position of Meeting: " + empActions.search("Meeting"));
        System.out.println("position of Meeting: " + empActions.search("Lunch Break"));
        //Use contains() to check if specific actions exist in the stack
        System.out.println("did emp leave work: " + empActions.contains("leave work"));
        // Iterate using standard for loop (Top to Bottom)
        for (int i = empActions.size() - 1; i >= 0; i--) {
            System.out.println(empActions.get(i));
        }
        //iterate through the stack using a standard for loop (from bottom to top)
        for(String action : empActions){
            System.out.println(action);
        }

        // Creating an iterator
        Iterator value = empActions.iterator();

        // Displaying the values
        // after iterating through the stack
        System.out.println("The iterator values are: ");
        while (value.hasNext()) {
            System.out.println(value.next());}
        //Display all actions with their index positions
        for (int i = 0; i < empActions.size(); i++) {
            System.out.println(i + ": " + empActions.get(i));
        }


    }

}
