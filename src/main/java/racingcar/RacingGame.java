package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int numberOfTrials;

    public RacingGame(String numberOfTrials, String... names) {
        validateNumberOfTrials(numberOfTrials);
        this.numberOfTrials = Integer.parseInt(numberOfTrials);
        this.cars = Arrays.stream(names)
                .map(Car::new)
                .toList();
    }

    private void validateNumberOfTrials(String numberOfTrials) {
        try {
            Integer.parseInt(numberOfTrials);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다.");
        }
    }

    public void trial() {
        cars.forEach(car -> {
            car.move(Randoms.pickNumberInRange(0, 9));
        });
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public void play() {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfTrials; i++) {
            trial();
            System.out.println(this.toString());
        }
    }

    public int getMaxPosition() {
        cars.sort(Car::compareTo);
        return cars.getFirst().getPosition();
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public String getWinnerNames() {
        List<Car> winners = getWinners();
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
