package racingcar.util;

public class PlayerValidation {

    public static void validation(String players) {
        if (!players.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
