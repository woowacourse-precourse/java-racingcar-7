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
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move();
                car.display();
            }
            System.out.println();
        }

        Car winner = getWinner();
        System.out.println("최종 우승자 : " + winner.getName());
    }

    public Car getWinner() {
        return cars.stream()
            .max((car1, car2) -> Integer.compare(car1.getPosition(), car2.getPosition()))
            .get();
    }
}
