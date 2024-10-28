package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

import static java.util.Collections.max;

public class GameService {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    public List<Car> createCarsList(String carNamesString) {
        String[] carNamesArray = splitCarNames(carNamesString);
        List<Car> cars = new ArrayList<>();

        for (String carName : carNamesArray) {
            carName = carName.trim();
            if (carNameValidator.validate(carName)) {
                Car car = createCar(carName);
                cars.add(car);
            }
        }

        return cars;
    }


    // 비어있는 cars가 인자로 들어올 경우... 예외처리 필요 -> 앞에서 처리했어야함.
    public int findMaxDistance(List<Car> cars) {
        return cars.stream()
                .flatMap(car -> car.getDistanceList().stream())
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0); // 리스트가 비어있을 경우 0 반환
    }

    public List<String> getWinners(List<Car> cars) {
        int maxDistance = findMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistanceList().get(0) == maxDistance) // maxDistance와 같은 거리를 가진 자동차 필터링
                .map(car -> car.getImmutableNameList().get(0)) // 자동차 이름을 가져옵니다.
                .collect(Collectors.toList()); // 리스트로 수집합니다.
    }

    private String[] splitCarNames(String carNamesString) {
        return carNamesString.split(","); // 자동차 이름을 콤마로 분리
    }

    private Car createCar(String carName) {
        return new Car(carName); // 자동차 객체 생성
    }


}
