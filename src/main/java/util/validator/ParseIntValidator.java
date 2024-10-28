package util.validator;

public class ParseIntValidator implements ParseValidator {
    @Override
    public void validateParseInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_PARSE_INT.getMessage());
        }
    }
}
