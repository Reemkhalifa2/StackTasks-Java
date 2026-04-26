import java.util.Stack;
public class TextEditorWithUndoRedo {
    static Stack<String> undoOperations = new Stack<>();
    static Stack<String> redoOperations = new Stack<>();
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) {
        type("Hello ");
        display();
        type("World ");
        display();
        type("Java ");
        display();
        undo();
        display();
        undo();
        display();
        redo();
        display();
        type("Stack ");
        display();
        undo();
        display();

    }
    public static StringBuilder type(String text){
        str.append(text);
        undoOperations.push(text);
        return str;
    }
    public static StringBuilder undo(){
        Integer undoLimit = 0;
        if(undoLimit>=10){
            undoOperations.clear();
            redoOperations.clear();
            undoLimit = 0;
        }
        if(!str.isEmpty()){
            String undoStr = undoOperations.pop();
            redoOperations.push(undoStr);
            str =str.delete(str.length()-undoStr.length(), str.length());
            undoLimit ++;
        }else{
            System.out.println("There is nothing to undo");
        }
        return str;
    }
    public static StringBuilder redo(){
        if(!redoOperations.isEmpty()){
            String redoStr = redoOperations.pop();
            undoOperations.push(redoStr);
            str.append(redoStr);
        }else{
            System.out.println("There is nothing to redo");
        }
        return str;
    }
    public static void display(){
        System.out.println("--------------------------");
        System.out.println(str);
        System.out.println("Undo stack: "+ undoOperations);
        System.out.println("Redo stack: "+ redoOperations);
    }

}
