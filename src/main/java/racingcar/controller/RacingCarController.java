package racingcar.controller;

import java.util.List;
import racingcar.model.car.Cars;
import racingcar.model.parseCar.ParseCar;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private String inputCar;

    private Integer inputCount;

    public RacingCarController() {
        inputCar = inputCarStr();
        inputCount = inputCount();
    }

    public void run() {
        //자동차 이름 추출
        List<String> carsName = ParseCar.parseCarName(inputCar);
        //자동차 객체 생성
        Cars cars = new Cars(carsName);
        //레이싱 시작, 현황 출력
        OutputView.startOutput();
        for (int i = 0; i < inputCount; i++) {
            cars.startRacingCars();
            OutputView.printCarRacingStatus(cars);
            cars.endRacingCars();
        }
        //우승자 결정하기
        cars.decisionWinnerCars();
        OutputView.printWinnerCars(cars);

    }

    private String inputCarStr() {
        return InputView.inputCarStr();
    }

    private Integer inputCount() {
        return InputView.inputCount();
    }

}
