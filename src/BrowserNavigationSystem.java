import java.util.Stack;
public class BrowserNavigationSystem {
    static Stack<String> backHistory = new Stack<>();
    static Stack<String> forwardHistory = new Stack<>();
    static String  currentPage ="";
    public static void main(String[] args) {

    }
    static void visitPage(String url){
        forwardHistory.clear();
        if(currentPage.isEmpty()){
            currentPage = url;
        }else{
            backHistory.push(currentPage);
            currentPage = url;
        }
    }
    void goBack(){
        if(!backHistory.isEmpty()){
            forwardHistory.push(currentPage);
            currentPage = backHistory.pop();
        }
    }
    void goForward() {
        if(!forwardHistory.isEmpty()){
            backHistory.push(currentPage);
            currentPage = forwardHistory.pop();
        }
    }
}
