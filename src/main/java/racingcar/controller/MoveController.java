package racingcar.controller;

import racingcar.model.CarMovement;
import racingcar.model.Race;
import racingcar.view.OutputView;

public class MoveController {
    private final CarMovement carMovement;
    private final OutputView outputView;

    public MoveController(CarMovement carMovements) {
        this.carMovement = new CarMovement();
        this.outputView = new OutputView();
    }

    public void runMove(Race race, int tryCount) {
        outputView.printRunResult(); // 실행 결과 메시지 출력
        for (int i = 0; i < tryCount; i++) {
            race.moveCars(carMovement); // 자동차 이동 실행
            outputView.printCarPositions(race.getCars()); // 현재 자동차 위치 출력
        }
    }
}
