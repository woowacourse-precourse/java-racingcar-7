package OnGame;

import java.util.StringJoiner;

public class RacingCar {

    public enum ErrorMessage {
        LONG_NAME_ERROR("자동차 이름이 5글자를 넘을 수 없습니다.");
        private final String message;

        ErrorMessage(final String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }

    private final String name;

    public RacingCar(final String name) {
        final String trimName = name.trim();
        isValidName(trimName);
        this.name = trimName;
    }

    private void isValidName(final String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.LONG_NAME_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(",", RacingCar.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
