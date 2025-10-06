class MyLinkedList {

    private class ListNode{
        private int val;
        private ListNode next;
        private ListNode prev;

        public ListNode(int val){
            this.val = val;
            next = null;
            prev = null;
        }

        public ListNode(int val, ListNode next, ListNode prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private ListNode list;
    private int size;

    public MyLinkedList() {
        list = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }

        ListNode crr = this.list;
        while(crr != null && index > 0){
            crr = crr.next;
            index--;
        }

        return crr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, list, null);
        if(list != null){
            list.prev = newNode;
        }

        list = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(list == null){
            list = new ListNode(val);
            size++;
            return;
        }

        ListNode crr = this.list;
        while(crr.next != null){
            crr = crr.next;
        }

        crr.next = new ListNode(val, null, crr);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == size){
            addAtTail(val);
            return;
        }

        if(index == 0){
            addAtHead(val);
            return;
        }

        if(index < 0 || index > size){
            return;
        }

        ListNode crr = this.list;
        for(int i = 0; i < index - 1;i++){
            crr = crr.next;
        }

       ListNode newNode = new ListNode(val, crr.next, crr);
        if (crr.next != null) {
            crr.next.prev = newNode;
        }
        crr.next = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        ListNode crr = list;

        if(index == 0){
            list = list.next;
            if(list != null) list.prev = null;
            size--;
            return;
        }

        for(int i = 0; i < index; i++){
            crr = crr.next;
        }

        
        if(crr != null){
            if(crr.prev != null) crr.prev.next = crr.next;
            if(crr.next != null) crr.next.prev = crr.prev;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */