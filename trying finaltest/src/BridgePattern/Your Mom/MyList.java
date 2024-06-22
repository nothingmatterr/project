public interface MyList extends MyIterable{
    void append(Object value);
    Object get(int index);
    void insert(Object value, int index);
    void remove(int index);
    void set(Object value, int index);
    int size();

}
