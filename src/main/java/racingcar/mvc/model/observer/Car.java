package racingcar.mvc.model.observer;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigInteger;
import java.util.Objects;

public class Car implements CarObserver {
    private String name;
    private BigInteger distance;

    public Car(String name) {
        this.name = name;
        this.distance = BigInteger.ZERO;
    }

    public BigInteger getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update() {
        if (goOrStop()) {
            distance = distance.add(BigInteger.ONE);
        }

        System.out.println(toString());
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean goOrStop() {
        if (makeRandomNumber() >= 4) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + " : " + printDistance();
    }

    private String printDistance() {
        StringBuilder print = new StringBuilder();

        for (BigInteger i = BigInteger.ZERO; i.compareTo(distance) < 0; i = i.add(BigInteger.ONE)) {
            print.append("-");
        }

        return print.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(distance);
    }
}
