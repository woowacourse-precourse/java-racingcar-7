package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.io.InputHandler;
import racingcar.io.OutputHandler;

import java.util.List;

import static racingcar.constant.RaceConfig.RANDOM_END_NUMBER;
import static racingcar.constant.RaceConfig.RANDOM_START_NUMBER;

public class Racing {

    private static final InputHandler input = new InputHandler();
    private static final OutputHandler output = new OutputHandler();

    public void race() {
        List<String> carNames = input.inputCarName();
        List<Car> cars = Car.createCars(carNames);
        int count = input.inputCount();

        output.printStart();
        runRace(cars, count);
    }

    private void runRace(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            raceRound(cars);
            output.printStatus(cars);
        }
    }

    private void raceRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = getRandomNumber();
            car.moveOrStop(randomNumber);
        }
    }


    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
    }
}
