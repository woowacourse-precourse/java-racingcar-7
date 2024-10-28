package racingcar.presentation.ui;

import racingcar.presentation.enums.UiMessage;

public class InputView {

    public void inputCarNameUi() {
        System.out.println(UiMessage.UI_INPUT_CAR_NAME_MESSAGE.getMessage());
    }

    public void inputTryUi() {
        System.out.println(UiMessage.UI_INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }
}
