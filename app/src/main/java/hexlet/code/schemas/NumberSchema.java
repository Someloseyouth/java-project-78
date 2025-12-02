package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean positive;
    private int minRange = Integer.MIN_VALUE;
    private int maxRange = Integer.MAX_VALUE;

    public NumberSchema required() {
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        this.positive = true;
        return this;
    }

    public NumberSchema range(int minRangeValue, int maxRangeValue) {
        this.minRange = minRangeValue;
        this.maxRange = maxRangeValue;
        return this;
    }

    @Override
    public boolean isValid(Integer value) {
        if (!required) {
            return true;
        }
        // проверка на null
        if (value == null) {
            return false;
        }
        // проверка положительного числа
        if (positive && value <= 0) {
            return false;
        }
        // проверка числа на вхождение в заданный диапазон
        if (value < minRange || value > maxRange) {
            return false;
        }

        return true;
    }
}
