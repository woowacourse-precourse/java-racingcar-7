package racingcar.game;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final int moveCount;

    public Racing(List<Car> cars, int moveCount) {
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public Racing(String names, int moveCount) {
        this.cars = CarFactory.createCars(names);
        this.moveCount = moveCount;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move();
                car.display();
            }
            System.out.println();
        }

        displayWinner();
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
