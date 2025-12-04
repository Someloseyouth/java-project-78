package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> checks = new HashMap<>();
    protected boolean required;

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    public boolean isValid(T value) {
        if (!required && value == null) {
            return true;
        }
        if (required && value == null) {
            return false;
        }
        if (value != null) {
            for (Predicate<T> validate : checks.values()) {
                if (!validate.test(value)) {
                    return false;
                }
            }
        }

        return true;
    }
}
