package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.utils.Parser;

public class Racing {
    public List<Car> cars = new ArrayList<>();
    public int trialCount;

    private static final int MOVING_NUMBER = 4;

    public Racing(String inputCars, String inputTrialCount) {
        List<String> carNames = Parser.parseCarNames(inputCars);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        trialCount = Integer.parseInt(inputTrialCount);
    }

    public void runRace() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= MOVING_NUMBER) {
                car.move();
            }
        }

        printRaceStatus();
    }

    private void printRaceStatus() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getMoveString()));
        System.out.println();
    }

    public String createWinnerList() {
        int winnerScore = getWinnerScore();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMoveCount() == winnerScore) {
                winners.add(car.getName());
            }
        }

        return String.join(", ", winners);
    }

    private int getWinnerScore() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getMoveCount))
                .get()
                .getMoveCount();
    }

}
