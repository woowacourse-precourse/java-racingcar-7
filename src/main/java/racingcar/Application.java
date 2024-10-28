package racingcar;

import racingcar.view.CarNameInputView;
import racingcar.view.MoveCountInputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameInputView carNameInputView = new CarNameInputView();
        carNameInputView.input();

        MoveCountInputView moveCountInputView = new MoveCountInputView();
        moveCountInputView.input();
    }
}
