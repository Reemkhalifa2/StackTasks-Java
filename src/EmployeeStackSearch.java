import java.util.Stack;
public class EmployeeStackSearch {
    public static void main(String[] args) {
        Stack<String> empActions = new Stack<>();
        //Add at least 5 employee action records using the push() method
        empActions.push("Start work");
        empActions.push("Meating");
        empActions.push("Lunch Break");
        empActions.push("Writing report");
        empActions.push("leave work");

        //Display the current stack with their positions from top
        for(String action : empActions){
            Integer position =  empActions.search(action);
            System.out.println(action+ " : "+ position);
        }
    }

}
