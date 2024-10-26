package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.validate.CarNameValidation;

public class RacingCarGame {

    List<Car> cars = new ArrayList<>();

    public RacingCarGame(List<String> carNames) {
        for (String carName : carNames) {
            CarNameValidation.validateName(carName);
            cars.add(new Car(carName));
        }
        RacingCarsGroup racingCarsGroup = new RacingCarsGroup(cars);
    }

    public void playCarGame(int inputNumbersOfAttempts) {

    }

    public List<Integer> generateMove(int totalCars) {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < totalCars; i++) {
            int move = Randoms.pickNumberInRange(0, 9);
            moves.add(move);
        }
        return moves;

    }

}
