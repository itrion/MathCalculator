package core;

public abstract class Type<T> {
    private T value;
    private String name;

    public Type(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public abstract String getName();
}
