package racingcar;

public class ErrorValidator {
    public static void carName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (carName.length() > Contants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static void gameCount(String game_count) {
        try {
            Integer.parseInt(game_count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
