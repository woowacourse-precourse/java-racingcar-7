package racingcar;

import java.util.HashSet;
import java.util.Set;

public class CarRegistry {
    private final Set<Car> cars;
    private static CarRegistry INSTANCE;

    public static CarRegistry getInstance(String carNames) {
        if (INSTANCE == null) {
            INSTANCE = new CarRegistry(carNames);
        }
        return INSTANCE;
    }

    private CarRegistry(String carNames) {
        this.cars = convertCarNamesToCarSet(carNames);
    }

    private Set<Car> convertCarNamesToCarSet(String input) {
        Set<Car> cars = new HashSet<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(createCar(carName));
        }
        return cars;
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    public Set<Car> getCars() {
        return cars;
    }

    public Set<String> getWinnerNames() {
        Integer max = 0;
        Set<String> winnerNames = new HashSet<>();
        for(Car car : cars) {
            if (car.getPosition().equals(max)) {
                winnerNames.add(car.getName());
            }
            if(car.getPosition() > max) {
                max = car.getPosition();
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    /**
     * 객체의 문자열 표현을 반환합니다.
     * 이 표현은 객체의 이름과 함께 현재 위치에 해당하는
     * 대시('-')로 구성된 문자열을 포함합니다.
     *
     * @return 이름들과 각각의 현재 위치에 따라 결정된 대시가 포함된
     *         형식 "이름 : ----" 형태의 문자열을 모두 합쳐 반환합니다.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(car.toString()).append("\n");
        }
        return builder.toString();
    }
}
