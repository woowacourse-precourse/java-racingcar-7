package racingcar.console;

final class Convertor {

    private Convertor() {
    }

    public static Convertor init() {
        return new Convertor();
    }

    public Long parseLong(final String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능");
        }
    }
}