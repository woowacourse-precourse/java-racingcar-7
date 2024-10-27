package racingcar.domain;

public class TrialCount {
    private static final int MIN_TRIAL_COUNT = 1;
    private final int amount;

    public TrialCount(String amount) {
        validateIsNumber(amount);
        int num = Integer.parseInt(amount);
        validateAmountRange(num);
        this.amount = num;
    }

    public int getAmount() {
        return this.getAmount();
    }

    private void validateIsNumber(final String str) {
        try {
            Integer.parseInt(str); // 또는 Double.parseDouble(str)
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }

    }

    private void validateAmountRange(final int num) {
        if (num < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1이상만 입력 가능합니다.");
        }
    }
}
