package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected boolean required;
    abstract boolean isValid(T value);
}
