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


        urlsStack.pop();
        //display the current page
        System.out.println(urlsStack.peek() );

    }
}