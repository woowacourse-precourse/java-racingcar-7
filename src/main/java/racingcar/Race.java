package racingcar;
import java.util.List;
import java.util.ArrayList;

public class Race {
    private List<Car> cars;
    private Printer printer;

    public Race(List<String> carNames, MoveStrategy moveStrategy, Printer printer) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, moveStrategy));
        }
        this.printer = printer;
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
            printer.printStatus(cars);
        }
        printer.printWinners(cars);
    }

}