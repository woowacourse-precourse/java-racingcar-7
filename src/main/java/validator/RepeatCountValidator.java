package validator;

public class RepeatCountValidator {

    public static void validateInputRepeatCount(String inputRepeatCount) {
        isNotEmpty(inputRepeatCount);
        isNotBigNumber(inputRepeatCount);
        isNotNegativeNumber(Integer.parseInt(inputRepeatCount));
    }

    private static void isNotEmpty(String inputRepeatCount) {
        if (inputRepeatCount.isEmpty()) {
            throw new IllegalArgumentException("반복 횟수가 입력되지 않았습니다.");
        }
    }

    private static void isNotBigNumber(String inputRepeatCount) {
        try {
            Integer.parseInt(inputRepeatCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("반복횟수가 너무 큽니다.");
        }
    }


    private static void isNotNegativeNumber(int repeatCount) {
        if (repeatCount < 0) {
            throw new IllegalArgumentException("반복 횟수는 0 이상의 정수 입니다.");
        }
    }

}
