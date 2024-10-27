package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String carRegistrationRequest = inputView.readCarRegistrationRequest();
        List<String> carNames = Arrays.asList(carRegistrationRequest.split(","));
        List<Car> cars = carNames.stream().map(Car::new).toList();
        int roundCount = inputView.readRoundCount();

        System.out.println("/n실행 결과");
        for(int round = 0; round < roundCount; round++) {
            playRound(cars);
        }
    }

    private void playRound(List<Car> cars) {
        for(Car car:cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
        }
    }
}
