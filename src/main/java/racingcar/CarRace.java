package racingcar;

import java.math.BigInteger;
import java.util.HashMap;


public class CarRace {

    private final HashMap<String, BigInteger> cars;
    private final BigInteger tryCount;

    public CarRace(String cars, String tryCount) {
        this.cars = getCar(cars);
        this.tryCount = getCount(tryCount);
    }

    private HashMap<String, BigInteger> getCar(String input) {
        try {
            String[] cars = input.split(",");

            HashMap<String, BigInteger> carMap = new HashMap<>();
            for (String car : cars) {
                carMap.put(car, BigInteger.ZERO);
            }

            return carMap;
        } catch (Exception e) {
            throw new IllegalArgumentException("쉼표(,)로 구분된 자동차 이름을 입력해주세요", e);
        }
    }

    private BigInteger getCount(String input) {
        try {
            return new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1이상의 숫자를 입력해주세요", e);
        }
    }

    @Override
    public String toString() {
        return "CarRace{" +
                "cars=" + cars +
                ", tryCount=" + tryCount +
                '}';
    }
}

