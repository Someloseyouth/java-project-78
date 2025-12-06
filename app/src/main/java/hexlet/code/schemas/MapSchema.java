package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {

    public MapSchema required() {
        required = true;
        addCheck("required", value -> value != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", value -> value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addCheck("shape", mapValue -> {
            if (schemas == null || schemas.isEmpty()) {
                return true;
            }
            for (Map.Entry<String, BaseSchema<String>> entry : schemas.entrySet()) {
                String val = mapValue.get(entry.getKey());
                if (!entry.getValue().isValid(val)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
