package racingcar;

import racingcar.controller.CarRace;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String cars = InputView.input("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String num = InputView.input("시도할 횟수는 몇 회인가요?\n");

        CarRace carRace = new CarRace(cars, Integer.parseInt(num));
        OutputView.printResult("실행 결과");
        carRace.startRace();
    }
}
