package racingcar.view;

import racingcar.util.IOMessage;

public class InputView {

    public void printInputCarNameMessage() {
        System.out.println(IOMessage.INPUT_CAR_NAME_MESSAGE.getMessage());
    }

    public void printInputTrialMessage() {
        System.out.println(IOMessage.INPUT_TRIAL_MESSAGE.getMessage());
    }
}
