package hexlet.code.schemes;

import hexlet.code.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberSchemeTest {
    private Validator v;
    private NumberSchema schema;

    @BeforeEach
    void setUp() {
        v = new Validator();
        schema = v.number();
    }

    @Test
    void isValidNull() {
        boolean result = schema.isValid(null);
        Assertions.assertTrue(result);
    }

    @Test
    void isValidInteger() {
        boolean result = schema.isValid(5);
        Assertions.assertTrue(result);
    }

    @Test
    void requiredIsValidNull() {
        boolean result = schema.required().isValid(null);
        Assertions.assertFalse(result);
    }

    @Test
    void requiredIsValidInteger() {
        boolean result = schema.required().isValid(10);
        Assertions.assertTrue(result);
    }

    @Test
    void requiredPositiveIsValidInteger() {
        boolean result = schema.required().positive().isValid(11);
        Assertions.assertTrue(result);
    }

    @Test
    void requiredPositiveIsValidIntegerFalse() {
        boolean result = schema.required().positive().isValid(-10);
        Assertions.assertFalse(result);
    }

    @Test
    void allRulesCombination() {
        boolean result = schema.required().range(5, 10).isValid(5);
        Assertions.assertTrue(result);
    }

    @Test
    void outOfRangeInteger() {
        boolean result = schema.required().range(5, 10).isValid(3);
        Assertions.assertFalse(result);
    }


}
