package racingcar;

public class Car {
    private static final String ERROR_MESSAGE_CARNAME_LENGTH = "자동차 이름은 5자 이하로 해주세요.";
    private static final String ERROR_MESSAGE_CARNAME_EMPTY = "자동차 이름은 공백을 허용하지 않습니다.";
    private static final String ERROR_MESSAGE_CARNAME_CHAR = "자동차 이름은 숫자와 문자만 가능해요.";
    private static final int MAX_CARNAME_LENGTH = 5;
    private static final int MOVE_DISTANCE = 1;
    private String name;
    private int location;

    private Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public static Car from(String name) {
        validateCarName(name);
        return new Car(name);
    }

    public boolean isAtLocation(int location) {
        return this.location == location;
    }

    public static void validateCarName(String input) {
        checkBlank(input);
        checkLength(input);
        checkChar(input);
    }

    private static void checkBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CARNAME_EMPTY);
        }
    }

    private static void checkLength(String input) {
        if (input.length() > MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CARNAME_LENGTH);
        }
    }

    private static void checkChar(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ERROR_MESSAGE_CARNAME_CHAR);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void forward() {
        location += MOVE_DISTANCE;
    }

}
