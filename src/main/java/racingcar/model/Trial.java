package racingcar.model;

public class Trial {

    private final int trial;

    public Trial(String trial) {
        this.trial = convertToInteger(trial);
    }

    private int convertToInteger(String trial) {
        try {
            int trialNum = Integer.parseInt(trial);
            validateNatural(trialNum);

            return trialNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요!");
        }
    }

    private void validateNatural(int trialNum) {
        if (trialNum <= 0) {
            throw new IllegalArgumentException("자연수만 입력해주세요!");
        }
    }

    public int getTrial() {
        return trial;
    }
}
