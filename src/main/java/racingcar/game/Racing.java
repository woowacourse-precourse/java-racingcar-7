package racingcar.game;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int roundNumber;

    public Racing(final List<Car> cars, final int roundNumber) {
        this.cars = cars;
        this.roundNumber = roundNumber;
    }

    public Racing(final String names, final int moveCount) {
        this.cars = CarFactory.createCars(names);
        this.roundNumber = moveCount;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            playRound();
            displayRoundResult();
        }

        displayWinner();
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRoundResult() {
        for (Car car : cars) {
            car.display();
        }
        System.out.println();
    }

    private void displayWinner() {
        List<Car> winners = getWinners();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners.stream()
                .map(Car::getName)
                .toList()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
