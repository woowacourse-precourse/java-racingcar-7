package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import org.jetbrains.annotations.NotNull;


public class Car implements Comparable<Car> {

    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveCar() {
        this.distance += Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public int compareTo(@NotNull Car o) {
        return this.distance - o.distance;
    }

    @Override
    public String toString() {
        return String.join(" : ", this.name, "-".repeat(this.distance));
    }
}
