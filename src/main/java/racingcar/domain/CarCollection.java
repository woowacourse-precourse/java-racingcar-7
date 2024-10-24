package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record CarCollection(List<Car> cars) {
    public CarCollection(List<Car> cars) {
        validateCarNamesAreUnique(cars);
        this.cars = List.copyOf(cars);
    }

    /**
     * 입력된 문자열을 쉼표로 분리하여 CarCollection 객체를 생성합니다. 각 분리된 문자열은 자동차 이름으로 사용되며, CarName과 Car 객체로 변환된 후 리스트에 담아
     * CarCollection을 생성합니다.
     *
     * @param input 자동차 이름을 쉼표(,)로 구분한 문자열
     * @return CarCollection 객체
     * @throws IllegalArgumentException 유효하지 않은 자동차 이름이 포함된 경우
     */
    public static CarCollection from(String input) {
        List<Car> carList = parseCars(input);
        return new CarCollection(carList);
    }

    private static List<Car> parseCars(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNamesAreUnique(List<Car> cars) {
        Set<String> uniqueNames = extractCarNames(cars);
        if (uniqueNames.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    private Set<String> extractCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());
    }

    public void moveAll() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public String getWinnerNames() {
        int maxPosition = getMaxPosition();
        List<Car> winners = getCarsWithMaxPosition(maxPosition);
        List<String> names = extractWinnerNames(winners);
        return String.join(", ", names);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> getCarsWithMaxPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<String> extractWinnerNames(List<Car> winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        return names;
    }

    public List<String> getCarStatuses() {
        List<String> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(extractCarStatus(car));
        }
        return statuses;
    }

    private String extractCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }
}
