package racingcar.model.entity;

import racingcar.utils.message.ErrorMessage;

/** 주행 시도 횟수를 담은 객체 : 입력값 검증 기능 수행 */
public record RacingChance(int chance) {

    /**
     * 콘솔로부터 자동차 주행 시도 횟수를 입력받아서 올바른 형식인지 검증한 다음
     * 정수(int)로 반환하는 메서드
     *
     * @param 검증되지 않은 자동차 주행 시도
     * @return 자동차 주행 시도 횟수
     * @throws 콘솔에서 입력된 문자열이 int 범위를 벗어나거나 숫자가 아닌 문자열이거나
     *              0이면 IllegalArgumentException 발생
     */
    public static RacingChance getAfterValidateFormat(String chanceToValidate) {
        validateBlank(chanceToValidate);
        validateInteger(chanceToValidate);
        validateZero(chanceToValidate);
        int validatedChance = Integer.parseInt(chanceToValidate);
        return new RacingChance(validatedChance);
    }

    private static void validateBlank(String numberToValidate) {
        if (numberToValidate.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.toString());
        }
    }

    private static void validateInteger(String numberToValidate) {
        try {
            Integer.parseInt(numberToValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INT.toString());
        }
    }

    private static void validateZero(String numberToValidate) {
        int number = Integer.parseInt(numberToValidate);
        if (number == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO.toString());
        }
    }

    public int getValue() {
        return chance;
    }

}
