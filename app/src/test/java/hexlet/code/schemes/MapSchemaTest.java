package hexlet.code.schemes;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class MapSchemaTest {
    private Validator v;
    private MapSchema schema;

    @BeforeEach
    void setUp() {
        v = new Validator();
        schema = v.map();
    }

    @Test
    void isValidNull() {
        boolean result = schema.isValid(null);
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidNull() {
        boolean result = schema.required().isValid(null);
        Assertions.assertFalse(result);
    }

    @Test
    void isValidEmptyMap() {
        boolean result = schema.required().isValid(new HashMap<>());
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidString() {
        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("key1", "value1");
        boolean result = schema.required().isValid(valueMap);
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidSizeofFalse() {
        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("key1", "value1");
        boolean result = schema.required().sizeof(2).isValid(valueMap);
        Assertions.assertFalse(result);
    }

    @Test
    void allRulesCombination() {
        Map<String, String> valueMap = new HashMap<String, String>();
        valueMap.put("key1", "value1");
        valueMap.put("key2", "value2");
        boolean result = schema.required().sizeof(2).isValid(valueMap);
        Assertions.assertTrue(result);
    }
}
