package validator;

public class ParseIntValidator implements ParseValidator {
    @Override
    public void validateParse(String input) {
        validateParseInt(input);
    }

    private void validateParseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_PARSE_INT.getMessage());
        }
    }
}
