package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarMovement;
import racingcar.model.RaceWinner;
import racingcar.model.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {

    public void startRace() {
        String carInput = InputView.getCarNames();
        List<String> cars = Car.getCar(carInput);

        // 자동차 이름 유효성 검사
        Validator.carNames(cars);

        List<Integer> carPositions = Car.getCarPositions(cars);
        int trialCount = InputView.getTrialCount();
        System.out.println(); // 줄바꿈(미션 출력 요구 사항)
        System.out.println("실행 결과");

        // 시도 횟수만큼 레이스 진행
        while (trialCount  > 0) {
            CarMovement.moveCarsForward(carPositions);
            OutputView.displayRaceResult(cars, carPositions);
            trialCount --;
        }

        List<String> winners = RaceWinner.calculateWinners(cars, carPositions);
        OutputView.displayWinners(winners);
    }
}
