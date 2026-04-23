import java.util.Stack;
public class BrowserHistorySimulator {
    public static void main(String[] args) {
        Stack<String> urlsStack = new Stack<>();
        //Simulate visiting at least 5 different web pages using push()
        urlsStack.push("www.github.com");
        urlsStack.push("www.google.com");
        urlsStack.push("www.instagram.com");
        urlsStack.push("www.facebook.com");
        urlsStack.push("www.youtube.com");
        //Display the current page and all pages in history after each vis
        System.out.println(urlsStack);
        //Simulate pressing the "Back" button 2 times using pop()
        urlsStack.pop();
        //.Check if the history is empty
        System.out.println(urlsStack.isEmpty());
        urlsStack.pop();
        //display the current page
        System.out.println(urlsStack.peek() );
        urlsStack.clear();

        //check if stack id empty
        System.out.println(urlsStack.isEmpty());
        urlsStack.push("www.chatghpt.com");
        urlsStack.push("www.oracle.com");
        //Display the final browsing history
        System.out.println(urlsStack);


    }
}