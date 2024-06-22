public class MyLinkedList extends MyAbstractList{
    private MyLinkedListNode head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object get(int index) {
        if(index < 0 || index >= size){
            return null;
        }
        MyLinkedListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getPayload();
    }

    @Override
    public void set(Object payload, int index) {
        if(index < 0 || index >= size){
            return;
        }
        MyLinkedListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        current.setPayload(payload);
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size){
            return;
        }
        if(index == 0){
            head = head.getNext();
        }else{
            MyLinkedListNode current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    @Override
    public void append(Object payload) {
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if(head == null){
            head = newNode;
        }else{
            MyLinkedListNode current = head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insert(Object payload, int index) {
        if(index < 0 || index > size){
            return;
        }
        MyLinkedListNode newNode = new MyLinkedListNode(payload);
        if(index == 0){
            newNode.setNext(head);
            head = newNode;
        }else{
            MyLinkedListNode current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public MyIterator Iterator() {
        return new MyLinkedListIterator();
    }

    private MyLinkedListNode getNodeByIndex(int index) {
        if(index < 0 || index >= size){
            return null;
        }
        MyLinkedListNode current = head;
        for(int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current;
    }

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator() {
            this.currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Object next() {
            return getNodeByIndex(currentPosition++).getPayload();
        }

        @Override
        public void remove() {
            MyLinkedList.this.remove(currentPosition);
        }
    }
}