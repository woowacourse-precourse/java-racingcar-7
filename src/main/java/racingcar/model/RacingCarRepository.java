package racingcar.model;

import java.math.BigInteger;
import java.util.ArrayList;

public class RacingCarRepository {
    ArrayList<String> cars;
    ArrayList<BigInteger> values;
    Long tryCount;

    public RacingCarRepository() {
        this.cars = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    public ArrayList<String> getCars() {
        return cars;
    }

    public ArrayList<BigInteger> getValues() {
        return values;
    }

    public void addCar(String carName) {
        this.cars.add(carName);
        this.values.add(BigInteger.ZERO);
    }

    public void plusValue(int idx) {
        this.values.set(idx, this.values.get(idx).add(BigInteger.ONE));
    }

    public void setTryCount(Long tryCount) {
        this.tryCount = tryCount;
    }

    public Long getTryCount() {
        return tryCount;
    }
}
