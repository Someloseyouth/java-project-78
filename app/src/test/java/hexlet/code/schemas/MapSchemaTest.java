package hexlet.code.schemas;

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

    @Test
    void shapeTest() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        boolean result = schema.isValid(human1);
        Assertions.assertTrue(result);
    }

    @Test
    void shapeTestFalse() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        boolean result = schema.isValid(human2);
        System.out.println("CRITICAL: v.string().required().isValid(null) = " + result);
        System.out.println("EXPECTED: false | GOT: " + result);
        Assertions.assertFalse(result);
    }

    @Test
    void shapeTestNoValidMinLength() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        boolean result = schema.isValid(human3);
        Assertions.assertFalse(result);
    }
}
