package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.CarDto;
import racingcar.dto.RacingGameDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final String DELIMITER = ",";

    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = initializeCars(carNames);
        this.tryCount = tryCount;
    }

    private List<Car> initializeCars(String carNames) {
        List<String> carNamesList = List.of(carNames.split(DELIMITER));
        validateFormat(carNames, carNamesList);
        checkDuplicate(carNamesList);
        return carNamesList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateFormat(String carNames, List<String> carNameList) {
        int count = carNames.length() - carNames.replace(DELIMITER, "").length();
        if (count + 1 != carNameList.size()) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.: " + carNames);
        }
    }

    private void checkDuplicate(List<String> carNameList) {
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
                .map(Car::toCarDtO)
                .filter(dto -> dto.position() == maxPosition)
                .map(CarDto::name)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .map(Car::toCarDtO)
                .mapToInt(CarDto::position)
                .max()
                .orElse(0);
    }

    public RacingGameDto toRacingGameDto() {
        return new RacingGameDto(cars, tryCount);
    }
}
