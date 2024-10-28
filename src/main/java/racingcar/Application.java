package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGame racingGame = new RacingGame();
            racingGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}

class RacingGame {
    private List<Car> participatingCars;
    private int numberOfAttempts;

    public void start() {
        participatingCars = getParticipatingCarsFromUserInput();
        numberOfAttempts = getNumberOfAttemptsFromUserInput();
    }

    private List<Car> getParticipatingCarsFromUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        String[] carNames = userInput.split(",");
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            carName = carName.trim();
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
            carList.add(new Car(carName));
        }

        return carList;
    }

    private int getNumberOfAttemptsFromUserInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해주세요.");
        }
    }

    public void playAllRounds() {
        for (int currentRound = 0; currentRound < numberOfAttempts; currentRound++) {
            playSingleRound();
        }
    }

    private void playSingleRound() {
        for (Car car : participatingCars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.moveForward();
            }
        }
    }
}

class Car {
    private final String carName;
    private int currentPosition;

    public Car(String carName) {
        this.carName = carName;
        this.currentPosition = 0;
    }

    public String getName() {
        return carName;
    }

    public void moveForward() {
        currentPosition++;
    }
}