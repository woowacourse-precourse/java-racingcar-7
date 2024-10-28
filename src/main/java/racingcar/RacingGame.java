package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private static final List<Car> cars = new ArrayList<>();

    // 자동차 초기화
    public static void initializeCars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void racingCar(int attempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            attemptAllCarsMove();
            displayResults();
        }
    }

    private void attemptAllCarsMove() {
        for (Car car : cars) {
            moveCarIfConditionMet(car);
        }
    }

    private void moveCarIfConditionMet(Car car) {
        if (isMoveConditionMet()) {
            car.move();
        }
    }

    private boolean isMoveConditionMet() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void displayResults() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void startGame(String[] carNames, int attempts) {
        RacingGame racingGame = new RacingGame();
        racingGame.initializeCars(carNames);
        racingGame.racingCar(attempts);
    }
}
