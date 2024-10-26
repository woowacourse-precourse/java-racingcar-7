package racingcar.car;


import static racingcar.constant.CarStatus.INITIAL_STATE;

public class Car implements Comparable<Car> {
    String name;
    int status = INITIAL_STATE.value();

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        status++;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.status, this.status);
    }

    @Override
    public String toString() {
        return name + " : " + ("-").repeat(status);
    }
}
