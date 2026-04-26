import java.util.Stack;
public class BrowserNavigationSystem {
    static Stack<String> backHistory = new Stack<>();
    static Stack<String> forwardHistory = new Stack<>();
    static String  currentPage ="";
    public static void main(String[] args) {

    }
    static void visitPage(String url){
        if(currentPage.isEmpty()){
            currentPage = url;
        }else{
            backHistory.push(currentPage);
            currentPage = url;
        }
    }
}
