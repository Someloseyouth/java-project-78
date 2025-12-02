package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
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
        // проверка на null и пустой String
        if (value == null || value.isEmpty()) {
            return false;
        }
        // проверка минимальной длины
        if (minLength > 0 && value.length() < minLength) {
            return false;
        }
        // проверка на содержание подстроки
        if (contains != null && !value.contains(contains)) {
            return false;
        }

        return true;

    }
}
