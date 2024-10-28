package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCarGame {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        return carNames;
    }

    public int getMoveCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int moveCount = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
            if (moveCount <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
            }
            return moveCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public boolean canMove() {
        int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    // RacingCarGame.java

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.moveForward();
            }
        }
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void startRace(List<Car> cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            moveCars(cars);
            printRoundResult(cars);
        }
    }
}

