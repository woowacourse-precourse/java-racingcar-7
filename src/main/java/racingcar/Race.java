package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void start(int rounds) {
        for (int i = 0; i < rounds; i++) {
            playRound();
            printRoundResult();
        }
        printWinners();
    }

    private void playRound() {
        cars.forEach(this::moveCarIfEligible);
    }

    private void moveCarIfEligible(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        car.move(randomNumber);
    }

    private void printRoundResult() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = getWinnersWithMaxPosition(maxPosition);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> getWinnersWithMaxPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
