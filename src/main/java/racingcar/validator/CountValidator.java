package racingcar.validator;

public class CountValidator {

    public static void checkValidCount(String strCount) throws Exception {
        checkCountIsNumeral(strCount);
        checkCountIsPositive(strCount);
    }

    private static void checkCountIsNumeral(String strCount) throws Exception {
        try {
            Integer.parseInt(strCount);
        } catch (NumberFormatException e) {
            throw new Exception("횟수는 숫자만 입력 가능합니다.");
        }
    }

    private static void checkCountIsPositive(String strCount) throws Exception {
        int count = Integer.parseInt(strCount);
        if (count < 0) {
            throw new Exception("횟수는 양수여야 합니다.");
        }
    }

}
