package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarMoveCountDto;
import racingcar.dto.CarMoveHistoryDto;
import racingcar.exception.RaceException;
import racingcar.utility.StringUtility;

public class Cars {

    private final static String DUPLICATE_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(String raceCarNames){
        List<String> carNames = StringUtility.splitStringToList(raceCarNames);
        if(!areCarNamesUnique(carNames)){
            throw new RaceException(DUPLICATE_CAR_NAME_MESSAGE);
        }

        cars = createCars(carNames);
    }

    private boolean areCarNamesUnique(List<String> carNames) {
        return !StringUtility.isDuplicateStrExists(carNames);
    }

    private List<Car> createCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars){
            car.move();
        }
    }

    public List<CarMoveHistoryDto> getCarMoveHistoryDtoList(){
        return cars.stream()
                .map(Car :: toMoveHistoryDto)
                .toList();
    }

    public List<CarMoveCountDto> getCarMoveCountDtoList() {
        return cars.stream()
                .map(Car :: toMoveCountDto)
                .toList();
    }
}
