package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.RaceException;
import racingcar.utility.StringUtility;

public class Cars {

    private final static String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";
    private final static String MOVE_HISTORY_FORMAT = "%s : %s";
    public final List<Car> cars;

    public Cars(String raceCarNames){
        List<String> carNames = StringUtility.splitStringToList(raceCarNames);
        if(!areCarNamesUnique(carNames)){
            throw new RaceException(DUPLICATE_CAR_NAME_MESSAGE);
        }

        cars = createCars(carNames);
    }

    private boolean areCarNamesUnique(List<String> carNames) {
        return StringUtility.isDuplicateStrExists(carNames);
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int getCarCount(){
        return cars.size();
    }

    public void move() {
        for (Car car : cars){
            car.move();
        }
    }

    public String formatCarsMoveHistory() {
        return cars.stream()
                .map(car -> String.format(MOVE_HISTORY_FORMAT, car.getName(), car.getMoveHistory()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public List<String> getWinners() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        if(maxMoveCount == 0){
            return Collections.emptyList();
        }

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
