package hexlet.code.schemes;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private String contains;

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

    @Override
    public boolean isValid(String value) {
        if (!required) {
            return true;
        }
        if (required && (value == null || value.isEmpty())) {
            return false;
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
