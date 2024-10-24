package racingcar.model.io;

import racingcar.utils.Constants;

public class RacingChance {

    private final int chance;

    private RacingChance(int chance) {
        this.chance = chance;
    }

    /**
     * 콘솔로부터 자동차 주행 시도 횟수를 입력받아서 올바른 형식인지 검증한 다음
     * 정수(int)로 반환하는 메서드
     * @param 검증되지 않은 자동차 주행 시도
     * @return 자동차 주행 시도 횟수
     * @throws 콘솔에서 입력된 문자열이 int 범위를 벗어나거나 숫자가 아닌 문자열이거나
     *              0이면 IllegalArgumentException 발생
     */
    public static RacingChance getAfterValidateForm(String chanceToValidate) {
        validateNotBlank(chanceToValidate);
        validateOnlyDigit(chanceToValidate);
        validateNotZero(chanceToValidate);
        int validatedChance = Integer.parseInt(chanceToValidate);
        return new RacingChance(validatedChance);
    }


    private static void validateNotBlank(String numberToValidate) {
        if (numberToValidate.isEmpty()) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX
                    + "문자열이 공백입니다. 숫자를 입력하세요.");
        }
    }

    private static void validateOnlyDigit(String numberToValidate) {
        try {
            Integer.parseInt(numberToValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX
                    + "숫자가 아니거나 int 범위를 벗어납니다.");
        }
    }

    private static void validateNotZero(String numberToValidate) {
        int number = Integer.parseInt(numberToValidate);
        if (number == 0) {
            throw new IllegalArgumentException(Constants.EXCEPTION_MESSAGE_PREFIX
                    + "시도할 횟수는 양수이어야 합니다.");
        }
    }

    public int get() {
        return chance;
    }
}
