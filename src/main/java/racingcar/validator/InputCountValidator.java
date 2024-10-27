package racingcar.validator;

public class InputCountValidator {
    private static final int MINMUM_TRY_COUNT = 1;

    public boolean isAboveMinimumTryCount(int tryCount) {
        if (tryCount < MINMUM_TRY_COUNT) {
            throw new IllegalArgumentException("0 이하의 숫자입니다.");
        }
        return true;
    }

    public boolean isValidScope (String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("int 자료형의 범위를 넘어서는 입력값입니다.");
        }
        return true;
    }

    public boolean isNotBlankTryCount(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
        return false;
    }
}
