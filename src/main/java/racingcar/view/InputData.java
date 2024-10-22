package racingcar.view;

public class InputData {
    public String carNames;
    public int trialNum;

    public InputData(String carNames, int trialNum) {
        this.carNames = carNames;
        this.trialNum = trialNum;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getTrialNum() {
        return trialNum;
    }

}
