package myLessson;

public class MyList <T>{

    @SuppressWarnings("unchecked")
    //private T[] arr = new T[10]; - not work
    private T[] arr = (T[]) new Object[10]; //cast
    private int size = 0;

    public void add(T value){
        arr[size] = value;
        size++;
    }

    public void set(int index, T value) {
    }

    public T get(int index) {
        return arr[index];
    }
}
