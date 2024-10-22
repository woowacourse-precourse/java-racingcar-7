package racingcar;

import racingcar.view.InputData;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        InputData inputData = inputView.inputCars();

        // 입력한 데이터 출력
        System.out.println("자동차 이름: " + inputData.getCarNames());
        System.out.println("시도 횟수: " + inputData.getTrialNum());

    }
}
