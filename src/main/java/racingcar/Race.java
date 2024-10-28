package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        Validation.validateCarNamesList(carNames);
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void start(int rounds) {
        Validation.validateRounds(rounds);
        for (int i = 0; i < rounds; i++) {
            playRound();
            displayCarsPosition();
        }
        displayWinners();
    }

    private void playRound() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    private void displayCarsPosition() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }

    private void displayWinners() {
        List<String> winners = getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
