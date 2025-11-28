package hexlet.code;

public class StringSchema {
    private int minLength;
    private String contains;
    private boolean required;

    public StringSchema() {

    }

    public StringSchema required() {
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLengthValue) {
        this.minLength = minLengthValue;
        return this;
    }

    public StringSchema contains(String containsString) {
        this.contains = containsString;
        return this;
    }

    public boolean isValid(String value) {
        if (required && (value == null || value.isEmpty())) {
            return false;
        }

        if ((value == null || value.isEmpty()) && !required) {
            return true;
        }

        if (minLength > 0 && value.length() < minLength) {
            return false;
        }

        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;

    }
}
