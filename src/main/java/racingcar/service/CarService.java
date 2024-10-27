package racingcar.service;

import racingcar.model.RacingCar; // RacingCar를 사용
import racingcar.model.enums.ExceptionMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarService {
    public List<RacingCar> createCars(String input) {
        validateInput(input);
        String[] names = input.split(",");

        Set<String> nameSet = new HashSet<>();
        List<RacingCar> cars = new ArrayList<>();
        for (String name : names) {
            name = name.trim();

            // 중복된 이름 체크
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUT_SAME_EXCEPTION.getMessage());
            }

            // 이름의 길이가 6자 이상인 경우 예외 발생
            if (name.length() > 5) {
                throw new IllegalArgumentException(ExceptionMessage.NAME_QUANTITY_EXCEPTION.getMessage());
            }

            cars.add(new RacingCar(name)); // RacingCar 객체 생성
        }
        return cars; // List<RacingCar> 반환
    }

    private void validateInput(String input) {
        if (input == null || input.isEmpty() || !input.contains(",")) {
            throw new IllegalArgumentException(ExceptionMessage.DELIMITER_NONEXISTENTION_EXCEPTION.getMessage());
        }
        if (input.matches(".*[^,].*,.*[^,].*")) { // 쉼표 외에 다른 구분자 체크
            throw new IllegalArgumentException(ExceptionMessage.DELIMITER_RANGE_EXCEPTION.getMessage());
        }
        if (input.split(",").length < 2) {
            throw new IllegalArgumentException(ExceptionMessage.DELIMITER_DUPLICATION_EXCEPTION.getMessage());
        }
    }
}
