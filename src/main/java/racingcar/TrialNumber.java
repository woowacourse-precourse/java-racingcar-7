package racingcar;

import java.util.regex.Pattern;

public class TrialNumber {
    private final int trialNumber;
    private final Pattern notDigitPattern = Pattern.compile("\\D");
    private int trial = 0;

    public TrialNumber(String inputTrialNumber) {
        validateTrialNumber(inputTrialNumber);
        this.trialNumber = parseTrialNumber(inputTrialNumber);
    }

    public int getTrialNumber() {
        return trialNumber;
    }

    public Boolean isTrialLowerThanTrialNumber() {
        return trial < trialNumber;
    }

    public void increaseTrial() {
        trial++;
    }

    private void validateTrialNumber(final String inputTrialNumber) {
        if (isNotDigitPattern(inputTrialNumber)) {
            throw new IllegalArgumentException();
        }

    }

    private Boolean isNotDigitPattern(final String inputTrialNumber) {
        return notDigitPattern.matcher(inputTrialNumber).find();
    }

    private int parseTrialNumber(String inputTrialNumber) {
        return Integer.parseInt(inputTrialNumber);
    }
}
