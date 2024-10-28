package racingcar.service;

import racingcar.domain.Car;
import racingcar.repository.RacingCarRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;

public class RacingCarGame implements Game {

    private final List<String> result = new ArrayList<>();
    private final RacingCarRepository racingCarRepository;

    public RacingCarGame(RacingCarRepository racingCarRepository) {
        this.racingCarRepository = racingCarRepository;
    }

    @Override
    public List<String> play(List<String> carNames, Integer round) {
        checkCarNames(carNames);
        createCars(carNames);
        for (int i = 0; i <round; i++) {
            race();
            result.add("");
        }
        addWinner2Result();
        return result;
    }

    private void race() {
        racingCarRepository.getCars().forEach(Car::move);
        addState2Result();
    }

    private void addState2Result() {
        List<Car> cars = racingCarRepository.getCars();
        cars.forEach(car -> result.add(getResultMessage(car).stripLeading()));
    }

    private String getResultMessage(Car car) {
        return car.getName() + " : " + convertPosition2String(car.getPosition());
    }

    private String convertPosition2String(Integer position) {
        return "-".repeat(max(0, position));
    }


    public void createCars(List<String> carNames) {
        carNames.forEach(racingCarRepository::addCarByName);
    }


    private void addWinner2Result() {
        int maxPosition = getMaxPosition();
        result.add("최종 우승자 : " + racingCarRepository.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElseThrow(IllegalArgumentException::new));
    }

    private int getMaxPosition() {
        return racingCarRepository.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }


    private void checkCarNames(List<String> carNames) {
        checkEmpty(carNames);
        checkDuplicate(carNames);
        checkLength(carNames);
    }

    private void checkLength(List<String> carNames) {
        if (carNames.stream().anyMatch(carName -> carName.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    private void checkDuplicate(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void checkEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
    }


}
