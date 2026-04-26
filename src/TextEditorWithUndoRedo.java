import java.util.Stack;
public class TextEditorWithUndoRedo {
    static Stack<String> undoOperations = new Stack<>();
    static Stack<String> redoOperations = new Stack<>();
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {

    }
    public static StringBuilder type(String text){
        str.append(text);
        return str;
    }
}
