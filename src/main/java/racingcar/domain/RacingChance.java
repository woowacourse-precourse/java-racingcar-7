package racingcar.domain;

public class RacingChance {

    private static final String EXCEPTION_RIGHT_CHANCE = "올바른 시도 횟수를 입력해주세요.";
    private static final int CHECK_MINUS_POINT = 0;

    private final int chance;

    public RacingChance(String racingChance) {
        validateEmptyChance(racingChance);
        validateNumberFormat(racingChance);
        validateMinusChance(racingChance);
        this.chance = Integer.parseInt(racingChance);
    }

    public int getRacingChance() {
        return chance;
    }

    private void validateNumberFormat(String racingChance) {
        try {
            Integer.parseInt(racingChance);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_RIGHT_CHANCE);
        }
    }

    private void validateEmptyChance(String racingChance) {
        if (racingChance == null || racingChance.isBlank()) {
            throw new IllegalArgumentException(EXCEPTION_RIGHT_CHANCE);
        }
    }

    private void validateMinusChance(String racingChance) {
        if (Integer.parseInt(racingChance) < CHECK_MINUS_POINT) {
            throw new IllegalArgumentException(EXCEPTION_RIGHT_CHANCE);
        }
    }
}
