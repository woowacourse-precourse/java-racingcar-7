package racingcar;

import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        String cars = InputView.input("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String num = InputView.input("시도할 횟수는 몇 회인가요?\n");
    }
}
