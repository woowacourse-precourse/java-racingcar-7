package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int moveCount;
    private final List<Car> cars;

    public RacingGame(int moveCount, List<String> carNames) {
        this.moveCount = moveCount;
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
        System.out.println();
        startGame();
    }

    void startGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < moveCount; i++) {
            move();
            System.out.println();
        }
        printWinners();
    }

    public void move() {
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            car.move(randomNum);
            car.printMoveCount();
        }
    }

    public int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);
    }

    public List<String> getWinners(int maxMoveCount) {
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .toList();
    }

    void printWinners() {
        int maxMoveCount = getMaxMoveCount();
        List<String> winners = getWinners(maxMoveCount);

        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
