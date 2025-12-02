package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    private int sizeof;
    private Map<String, BaseSchema<String>> shapeMap;

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
        // проверка на null
        if (required && valueMap == null) {
            return false;
        }
        // проверка соответствия мапы размеру заданному sizeof
        if (sizeof > 0 && valueMap.size() != sizeof) {
            return false;
        }
        // проверка данных внутри мапы
        if (shapeMap != null && !shapeMap.isEmpty()) {
            for (Map.Entry<String, BaseSchema<String>> entry : shapeMap.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> schema = entry.getValue();
                String val = valueMap.get(key);
                if (!schema.isValid(val)) {
                    return false;
                }
            }
        }
        return true;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        this.shapeMap = schemas;
        return this;
    }

}
