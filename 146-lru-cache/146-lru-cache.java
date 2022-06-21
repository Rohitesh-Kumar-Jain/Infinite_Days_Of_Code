class LRUCache {
    
    Map<Integer, ListNode> map = new HashMap<>();
    ListNode head, tail;
    int capacity;

    public LRUCache(int capacity) {
        head = new ListNode();
        tail = new ListNode();
        this.capacity = capacity;
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        ListNode cur = map.get(key);
        removeFromList(cur);
        addInFront(cur);
        
        return cur.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            removeFromList(map.get(key));
        }
        
        ListNode front = new ListNode(key, value);
        map.put(key, front);
        addInFront(front);
        
        if (map.size() > capacity) {
            ListNode last = removeFromLast();
            map.remove(last.key);
        }
        
    }
    
    private ListNode removeFromLast() {
        ListNode target = tail.prev;
        removeFromList(target);
        return target;
    }
    
    private void addInFront(ListNode node) {
        ListNode ahead = head.next;
        head.next = node;
        node.prev = head;
        node.next = ahead;
        ahead.prev = node;
    }
    
    private void removeFromList(ListNode node) {
        ListNode behind = node.prev;
        ListNode ahead = node.next;
        behind.next = ahead;
        ahead.prev = behind;
    }
    
    class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;
        
        public ListNode() {}
        
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */