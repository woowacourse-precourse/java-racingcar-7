package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.model.Validator;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {
    private static final int MOVE_THRESHOLD = 4;
    private final RacingCarView view;

    public RacingCarController(RacingCarView view) {
        this.view = view;
    }

    // 게임 실행 메서드
    public void run() {
        List<String> carNames = view.inputCarNames();
        Validator.validateCarNames(carNames);

        int rounds = Validator.validateRounds(view.inputRounds());
        Cars cars = new Cars(carNames);

        System.out.println("\n실행 결과");
        executeRounds(cars, rounds);
        view.printWinners(cars.getWinners());
    }

    // 지정된 횟수만큼 라운드를 실행
    private void executeRounds(Cars cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            cars.moveAllCars(MOVE_THRESHOLD, Randoms.pickNumberInRange(0, 9));
            view.printRoundResult(cars.getCars());
        }
    }
}
