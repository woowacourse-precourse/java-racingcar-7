package racingcar.car;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class CarRegistry {
    private final Set<Car> cars;
    private final StringBuilder carStatus;

    private static final Pattern VALID_CAR_NAMES_PATTERN = Pattern.compile("^[^,]+(,[^,]+)*$");

    public CarRegistry(String carNames) {
        validateCarNames(carNames);
        this.cars = convertCarNamesToCarSet(carNames);
        this.carStatus = new StringBuilder();
    }

    private void validateCarNames(String carNames) {
        if (carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
        if (!VALID_CAR_NAMES_PATTERN.matcher(carNames).matches()) {
            throw new IllegalArgumentException("Write valid comma between names");
        }
    }

    private Set<Car> convertCarNamesToCarSet(String input) {
        Set<Car> cars = new HashSet<>();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            cars.add(CarSimpleFactory.createCar(carName));
        }
        return cars;
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
        carStatus.setLength(0);
        for (Car car : cars) {
            carStatus.append(car.toString()).append("\n");
        }
        return carStatus.toString();
    }
}
