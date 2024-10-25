package racingcar;

public class ValidateCount {
    public static int manageCount(String userInputCount) {
        validateInputCount(userInputCount);
        return ParsingCount.parseInputCountToInt(userInputCount);
    }

    public static void validateInputCount(String userInputCount) {
        if (userInputCount == null || userInputCount.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        try {
            int count = Integer.parseInt(userInputCount);
            if (count <= 0) {
                throw new IllegalArgumentException("입력값은 1 이상의 자연수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
