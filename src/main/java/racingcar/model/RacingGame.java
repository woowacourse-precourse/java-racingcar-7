package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = initializeCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> initializeCars(String carNames) {
        List<String> carNamesList = List.of(carNames.split(","));
        validateFormat(carNames, carNamesList);
        checkDuplicate(carNamesList);
        return carNamesList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void validateFormat(String carNames, List<String> carNameList) {
        int count = carNames.length() - carNames.replace(",", "").length();
        if (count + 1 != carNameList.size()) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.: " + carNames);
        }
    }

    public void checkDuplicate(List<String> carNameList) {
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            throw new IllegalArgumentException("자동차 이름은 중복일 수 없습니다.");
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    public List<String> getAllCarStates() {
        return cars.stream()
                .map(Car::displayState)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
