package racingcar.model;

import java.util.stream.IntStream;
import racingcar.view.OutputView;

public class Car implements Comparable<Car> {
    private final Name name;
    private Distance distance;
    private static final int LIMIT = 4;

    private Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public static Car getInstance(String name) {
        return new Car(Name.from(name));
    }

    public String getName() {
        return name.getName();
    }

    public Integer getDistance() {
        return distance.getDistance();
    }

    public void move(int random) {
        if (isMoveForward(random)) {
            this.distance.increase();
        }
        print();
    }

    private boolean isMoveForward(int random) {
        return random >= LIMIT;
    }

    private void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getName()).append(" : ");
        IntStream.range(0, this.getDistance())
                .forEach((i) -> stringBuilder.append("-"));
        OutputView outputView = OutputView.INSTANCE;
        outputView.print(stringBuilder.toString());
    }

    @Override
    public int compareTo(Car car) {
        return car.getDistance() - this.getDistance();
    }
}
