import java.util.Stack;
public class HtmlTagValidator {
    public static void main(String[] args) {
        System.out.println(validateHtmlTags());

    }
    public static Boolean validateHtmlTags(String html){
        Stack<String> tagsStack = new Stack<>();

        for(int i=0; i <html.length();i++){
            String tag ="";
            if(html.charAt(i) == '<'){
                for(int j=i; j<html.length(); j++){
                    if(html.charAt(j)=='>'){
                        tag  = html.substring(i+1, j);
                        if(tag.endsWith("/")){
                            continue;
                        } else if (tag.endsWith("/")) {
                            if(tagsStack.isEmpty()){
                                return false;
                            }
                            if(tag.equals(tagsStack.pop()) ){
                                continue;
                            }else{
                                return false;
                            }

                        }

                    }
                }
            }

        }

    }
}
