package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validate.CarNameValidation;
import racingcar.view.OutputView;

public class RacingCarGame {

    List<Car> cars = new ArrayList<>();

    public RacingCarGame() {
    }

    public RacingCarGame(List<String> carNames) {
        CarNameValidation.validateName(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        RacingCarsGroup racingCarsGroup = new RacingCarsGroup(cars);
    }

    public void playCarGame(int inputNumbersOfAttempts) {
        OutputView.attemptsResult();
        for (int i = 0; i < inputNumbersOfAttempts; i++) {
            moveEachCars(generateMove(cars.size()));
            OutputView.eachAttemptsResult(cars);
        }
        OutputView.finalWinners();
        OutputView.finalWinnersResult(RacingCarsGroup.getFinalWinners(cars));

    }

    public List<Integer> generateMove(int totalCars) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < totalCars; i++) {
            int move = Randoms.pickNumberInRange(0, 9);
            moves.add(move);
        }
        return moves;

    }

    public void moveEachCars(List<Integer> moves) {
        List<Car> cars = RacingCarsGroup.getCars();
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) >= 4) {
                cars.get(i).increasePosition();
            }
        }
    }

}
