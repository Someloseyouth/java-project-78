package hexlet.code.schemes;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean positive;
    //    private boolean range;
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
        if (required && value == null) {
            return false;
        }
        if (positive && value <= 0) {
            return false;
        }
        if (value < minRange || value > maxRange) {
            return false;
        }

        return true;
    }
}
