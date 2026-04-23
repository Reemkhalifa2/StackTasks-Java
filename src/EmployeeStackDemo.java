import java.util.Stack;
public class EmployeeStackDemo {
    public static void main(String[] args) {
        Stack<String> empActions = new Stack<>();
        //Add at least 5 employee action records using the push() method
        empActions.push("Start work");
        empActions.push("Meating");
        empActions.push("Lunch Break");
        empActions.push("Writing report");
        empActions.push("leave work");

        //Display all elements in the Stack
        System.out.println("Stack after pushes: " + empActions);
        //Add one more employee action record
        empActions.push("work over time");
        //display the updated Stack
        System.out.println("Stack after pushes: " + empActions);


    }

}
