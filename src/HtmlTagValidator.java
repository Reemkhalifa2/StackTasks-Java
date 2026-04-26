import java.util.Stack;
public class HtmlTagValidator {
    public static void main(String[] args) {
        System.out.println(validateHtmlTags());

    }
    public static String validateHtmlTags(String html){
        Stack<String> tagsStack = new Stack<>();
        String tag ="";
        for(int i=0; i <html.length();i++){

            if(html.charAt(i) == '<'){
                for(int j=i; j<html.length(); j++){
                    if(html.charAt(j)=='>'){
                        tag  = html.substring(i+1, j);
                    }
                }

            }
        }
        return tag;
    }
}
