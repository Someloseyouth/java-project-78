package hexlet.code.schemes;

import hexlet.code.Validator;
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
        boolean result = schema.required().isValid(null);
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidEmptyString() {
        boolean result = schema.required().isValid("");
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidString() {
        boolean result = schema.required().isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidContainsTrue() {
        boolean result = schema.required().contains("Hex").isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValueContainsFalse() {
        boolean result = schema.required().contains("Java").isValid("Hexlet");
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidMinLengthTrue() {
        boolean result = schema.required().minLength(4).isValid("Hexlet");
        Assertions.assertTrue(result);

    }

    @Test
    void requiredIsValidMinLengthFalse() {
        boolean result = schema.required().minLength(21).isValid("Hexlet");
        Assertions.assertFalse(result);

    }

    @Test
    void requiredIsValueMinLengthMultipleCalls() {
        boolean result = schema.required().minLength(10).minLength(2).isValid("Hexlet");
        Assertions.assertTrue(result);
    }

    @Test
    void allRulesCombination() {
        boolean result = schema.required().minLength(5).contains("H").isValid("Hexlet");
        Assertions.assertTrue(result);
    }
}
