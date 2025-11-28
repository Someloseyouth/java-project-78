package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringSchemeTest {
    private Validator v;
    private StringSchema schema;

    @BeforeEach
    void setUp() {
        v = new Validator();
        schema = v.string();
    }

    @Test
    void isValidNull() {
        boolean result = schema.isValid(null);
        Assertions.assertTrue(result);
    }

    @Test
    void isValidEmptyString() {
        boolean result = schema.isValid("");
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidNull() {
        schema.required();
        boolean result = schema.isValid(null);
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidEmptyString() {
        schema.required();
        boolean result = schema.isValid("");
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidString() {
        schema.required();
        boolean result = schema.isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidContainsTrue() {
        schema.required();
        boolean result = schema.contains("Hex").isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValueContainsFalse() {
        schema.required();
        boolean result = schema.contains("Java").isValid("Hexlet");
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidMinLengthTrue() {
        schema.required();
        boolean result = schema.minLength(4).isValid("Hexlet");
        Assertions.assertTrue(result);

    }

    @Test
    void requiredIsValidMinLengthFalse() {
        schema.required();
        boolean result = schema.minLength(21).isValid("Hexlet");
        Assertions.assertFalse(result);

    }

    @Test
    void requiredIsValueMinLengthMultipleCalls() {
        schema.required();
        boolean result = schema.minLength(10).minLength(2).isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void allRulesCombination() {
        schema.required();
        boolean result = schema.minLength(5).contains("H").isValid("Hexlet");
        Assertions.assertTrue(result);
    }
}
