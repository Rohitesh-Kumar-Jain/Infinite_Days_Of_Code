class TextEditor {
    
    Stack<Character> behind = new Stack<>();
    Stack<Character> ahead = new Stack<>();

    public TextEditor() {
        
    }
    
    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            behind.push(ch);
        }
    }
    
    public int deleteText(int k) {
        int del = 0;
        while(k > 0 && behind.size() > 0) {
            behind.pop();
            del++; k--;
        }
        
        return del;
    }
    
    public String cursorLeft(int k) {
        while(k > 0 && behind.size() > 0) {
            ahead.push(behind.pop());
            k--;
        }
        
        Stack<Character> temp = new Stack<>();
        int i = 0;
        String s = "";
        
        while(i < 10 && behind.size() > 0) {
            char ch = behind.pop();
            s = ch + s; i++;
            temp.push(ch);
        }
        
        while(temp.size() > 0) {
            behind.push(temp.pop());
        }
        
        return s;
    }
    
    public String cursorRight(int k) {
        while(k > 0 && ahead.size() > 0) {
            behind.push(ahead.pop());
            k--;
        }
        
        Stack<Character> temp = new Stack<>();
        int i = 0;
        String s = "";
        
        while(i < 10 && behind.size() > 0) {
            char ch = behind.pop();
            s = ch + s; i++;
            temp.push(ch);
        }
        
        while(temp.size() > 0) {
            behind.push(temp.pop());
        }
        
        return s;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */