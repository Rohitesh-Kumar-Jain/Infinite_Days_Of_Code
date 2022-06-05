class TextEditor {
    
    int cursor;
    StringBuilder s;

    public TextEditor() {
        this.cursor = 0;
        this.s = new StringBuilder();
    }
    
    public void addText(String text) {
        s.insert(cursor, text);
        cursor += text.length();
    }
    
    public int deleteText(int k) {
        int oldCursor = cursor;
        cursor = Math.max(cursor - k, 0);
        s.delete(cursor, oldCursor);
        return oldCursor - cursor;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return s.substring(Math.max(0, cursor - 10), cursor);
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(s.length(), cursor + k);
        return s.substring(Math.max(0, cursor - 10), cursor);
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