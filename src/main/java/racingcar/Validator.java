package racingcar;

public class Validator {

    /**
     *
     * @param input
     * @return 정상 입력값 여부
     */
    public static boolean validateCarNames(String input) {
        if (input == null) return false;

        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.isBlank() || carName.trim().length() > 5) return false;
        }

        return true;
    }

    public static boolean validateTryCntInput(String input) {
        if (input == null) return false;
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
