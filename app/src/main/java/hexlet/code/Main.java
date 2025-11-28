package hexlet.code;

import hexlet.code.schemes.StringSchema;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();

        StringSchema schema = v.string();

        schema.isValid("");
        schema.isValid(null);

        schema.required();

        schema.isValid(null);
        schema.isValid("");
        schema.isValid("Hexlet");

        schema.contains("wh").isValid("what what what");

        StringSchema schema1 = v.string();
        schema1.minLength(10).minLength(4).isValid("Hexlet");
    }
}
