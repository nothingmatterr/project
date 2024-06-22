public abstract class MyAbstractList implements MyList{
    MyAbstractList(){
    }
    public String toString(){
        String result = "";
        for(int i = 0; i < size(); i++){
            result += get(i) + " ";
        }
        return result;
    }
}
