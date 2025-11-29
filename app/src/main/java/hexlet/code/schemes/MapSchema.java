package hexlet.code.schemes;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    private int sizeof;

    public MapSchema required() {
        this.required = true;
        return this;
    }

    public MapSchema sizeof(int sizeofValue) {
        this.sizeof = sizeofValue;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> valueMap) {
        if (!required) {
            return true;
        }
        if (required && valueMap == null) {
            return false;
        }
        if (sizeof > 0 && valueMap.size() != sizeof) {
            return false;
        }
        return true;
    }

}
