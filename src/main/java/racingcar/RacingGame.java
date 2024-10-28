package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int trialCount;

    public RacingGame(String carNamesInput, int trialCount) {
        validateCarNames(carNamesInput);
        for (String name : carNamesInput.split(",")) {
            cars.add(new Car(name));
        }
        this.trialCount = trialCount;
    }

    private void validateCarNames(String carNamesInput) {
        for (String name : carNamesInput.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public void start() {
        for (int i = 0; i < trialCount; i++) {
            race();
            printCurrentResults();
        }
        printWinners();
    }

    private void race() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private void printCurrentResults() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void printWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

}