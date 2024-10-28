package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.view.GameView;

public class GameService {
    private List<RacingCar> racingCars;
    private int numRounds;
    private final GameView gameView = new GameView();

    public void getCarNames() {
        String inputCarNames = gameView.inputCarNames();
        validateCarNames(inputCarNames);
        createCarList(inputCarNames);
    }

    private void validateCarNames(String inputCarNames) {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");
        }
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비워둘 수 없습니다.");
            }
        }
    }

    private void createCarList(String inputCarNames) {
        racingCars = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(carName);
            racingCars.add(racingCar);
        }
    }

    public void getRounds() {
        int inputRounds = gameView.inputRounds();
        validateRounds(inputRounds);
        numRounds = inputRounds;
    }

    private void validateRounds(int inputRounds) {
        if (inputRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }
}
