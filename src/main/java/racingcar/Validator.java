package racingcar;

public class Validator {

    /**
     *
     * @param input
     * @return 정상 입력값 여부
     */
    public static boolean validate(String input) {
        if (input == null) return false;

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.isBlank() || carName.trim().length() > 5) return false;
        }

        return true;
    }
}
