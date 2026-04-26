import java.util.Stack;
public class TextEditorWithUndoRedo {
    static Stack<String> undoOperations = new Stack<>();
    static Stack<String> redoOperations = new Stack<>();
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        System.out.println(type("Heelo"));
        System.out.println(type("Hi"));
        System.out.println(undo());

    }
    public static StringBuilder type(String text){
        str.append(text);
        undoOperations.push(text);
        return str;
    }
    public static StringBuilder undo(){
        if(!str.isEmpty()){
            String undoStr = undoOperations.pop();
            redoOperations.push(undoStr);
            str =str.delete(str.length()-undoStr.length(), str.length());
        }
        return str;

    }
}
