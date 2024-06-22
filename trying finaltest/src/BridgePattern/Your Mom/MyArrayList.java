public class MyArrayList extends MyAbstractList {
    private static final int DEFAULT_CAPACITY = 2;
    private Object[] data;
    private int size;

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
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
        return data[index];
    }

    @Override
    public void set(Object payload, int index) {
        if(index < 0 || index >= size){
            return;
        }
        data[index] = payload;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= size){
            return;
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public void append(Object payload) {
        if(size == data.length){
            enlarge();
        }
        data[size++] = payload;
    }

    @Override
    public void insert(Object payload, int index) {
        if(index < 0 || index > size){
            return;
        }
        if(size == data.length){
            enlarge();
        }
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = payload;
        size++;
    }

    @Override
    public MyIterator Iterator() {
        return new MyArrayListIterator();
    }

    private void enlarge() {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    private class MyArrayListIterator implements MyIterator {
        private int currentPosition;

        public MyArrayListIterator() {
            this.currentPosition = 0;
        }

        @Override
        public boolean hasNext() {
            return currentPosition < size;
        }

        @Override
        public Object next() {
            return data[currentPosition++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentPosition);
        }
    }
}