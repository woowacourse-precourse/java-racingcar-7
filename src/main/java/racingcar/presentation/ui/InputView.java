package racingcar.presentation.ui;

import racingcar.presentation.enums.UiMessage;

public class InputView {
    // TODO: 자동차 입력 메시지 출력
    public void inputCarNameUi() {
        System.out.println(UiMessage.UI_INPUT_CAR_NAME_MESSAGE.getMessage());
    }

    // TODO: 시도 횟수 입력 메시지 출력
    public void inputTryUi() {
        System.out.println(UiMessage.UI_INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }
}
