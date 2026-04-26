import java.util.Stack;
public class BrowserNavigationSystem {
    static Stack<String> backHistory = new Stack<>();
    static Stack<String> forwardHistory = new Stack<>();
    static String  currentPage ="";
    public static void main(String[] args) {
        visitPage("aaa");
        showHistory();
        showCurrentPage();
        visitPage("bbb");
        showHistory();
        showCurrentPage();
        goBack();
        showHistory();
        showCurrentPage();
        goForward();
        showHistory();
        showCurrentPage();
        visitPage("ccc");
        goBack();
        visitPage("ddd");
        showHistory();
        showCurrentPage();


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
    static void goBack(){
        if(backHistory.size() >= 10){
            backHistory.remove(0);
        }
        if(!backHistory.isEmpty()){
            forwardHistory.push(currentPage);
            currentPage = backHistory.pop();
        }else{
            System.out.println("Cannot go back");
        }
    }
    static void goForward() {
        if(!forwardHistory.isEmpty()){
            backHistory.push(currentPage);
            currentPage = forwardHistory.pop();
        }else{
            System.out.println("no forward history.");

        }
    }
    static void showCurrentPage(){
        System.out.println(currentPage);
    }
    static void showHistory(){
        System.out.println("Backword History: "+ backHistory);
        System.out.println("Forward History: "+ forwardHistory);
    }
}
