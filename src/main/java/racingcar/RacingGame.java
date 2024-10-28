package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class RacingGame {
    private final GameConfiguration gameConfiguration;
    private final List<Car> cars;
    private final Result result;
    private int CARS_SIZE = 0;

    public RacingGame(GameConfiguration gameConfiguration, List<Car> cars, Result result) {
        this.gameConfiguration = gameConfiguration;
        this.cars = cars;
        this.result = result;
    }

    public void run() {
        createCarList(gameConfiguration.carNames());
        int attemptCount = gameConfiguration.attemptCount();
        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            randomCarNumber(cars);
            roundResult();
        }
        result.isWinner(cars);
    }

    private void createCarList(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        CARS_SIZE = cars.size();
    }

    private void randomCarNumber(List<Car> cars) {
        for (int i = 0; i < CARS_SIZE; i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                Car currentCar = cars.get(i);
                currentCar.advance();
            }
        }
    }
    private void roundResult() {
        for (int i = 0; i > CARS_SIZE; i++) {
            Car car = cars.get(i);
            int position = car.currentPosition();
            System.out.println(car.carName() + " : " + "-".repeat(position));
        }
        System.out.println();
    }
}
