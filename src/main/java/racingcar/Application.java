package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        System.out.println(InputView.readNames());
        System.out.println(InputView.readRepeatCount());
    }
}
