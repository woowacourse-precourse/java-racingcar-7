package racingcar.domain;

public class RacingChance {

    private final int chance;

    public RacingChance(String racingChance) {
        validateNumberFormat(racingChance);
        this.chance = Integer.parseInt(racingChance);
    }

    public int getRacingChance() {
        return chance;
    }

    public void validateNumberFormat(String racingChance) {
        try {
            Integer.parseInt(racingChance);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 시도 횟수를 입력해주세요.");
        }
    }
}
