package racingcar;

public class Game {
    Cars cars;

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void play() {
        cars.moveAll();
        Output.printCarPosition(cars.getCarList());
    }
}
