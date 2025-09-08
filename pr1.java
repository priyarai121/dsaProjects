import java.util.*;

class UndoRedo {
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();
    private String text = "";

    
    public void performAction(String action) {
        undoStack.push(text);  
        text += action;        
        redoStack.clear();     
        System.out.println("Action performed: " + action);
        System.out.println("Current text: " + text);
    }

  
    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }
        redoStack.push(text);      
        text = undoStack.pop();    
        System.out.println("Undo performed. Current text: " + text);
    }

   
    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo!");
            return;
        }
        undoStack.push(text);      
        text = redoStack.pop();    
        System.out.println("Redo performed. Current text: " + text);
    }
    
    
}

public class pr1 {
    public static void main(String[] args) {
        UndoRedo editor = new UndoRedo();
        editor.performAction("Hello ");
        editor.performAction("World!");
        editor.undo();
        editor.redo();
    }
}