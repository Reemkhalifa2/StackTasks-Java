import java.util.Stack;

public class HtmlTagValidator {

    public static void main(String[] args) {
        String[] html = {
                "<div><b>text</b></div>",
                "<div><b>wrong</i></div>",
                "<html><body><h1>Title</h1></body></html>",
                "<br/>",
                "<div><p></div></p>",
                "",
                "<img src='x'/>",
                "<b><i></i></b>"
        };

        for (String h : html) {
            System.out.println(validateHtmlTags(h));
        }
    }
    public static boolean validateHtmlTags(String html) {
        Stack<String> tagsStack = new Stack<>();
        for (int i = 0; i < html.length(); i++) {
            if (html.charAt(i) == '<') {
                String tag = "";
                for (int j = i + 1; j < html.length(); j++) {
                    if (html.charAt(j) == '>') {

                        tag = html.substring(i + 1, j);
                        i = j;
                        break;
                    }
                }
                if (tag.equals("")) continue;
                //Handles self-closing tags (e.g., <br/>, <img src="..."/>)
                if (tag.endsWith("/")) {
                    continue;
                }
                // closing tag
                else if (tag.startsWith("/")) {
                    String tagName = tag.substring(1).split(" ")[0];

                    if (tagsStack.isEmpty()) {
                        return false;
                    }

                    if (!tagsStack.pop().equals(tagName)) {
                        return false;
                    }
                }
                // opening tag
                else {

                    String tagName = tag.split(" ")[0];
                    tagsStack.push(tagName);
                }
            }
        }

        return tagsStack.isEmpty();
    }
}