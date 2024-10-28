package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarValidator {

    public static void validate(List<Car> cars) {
        validateCarsCount(cars);
        validateSingleCar(cars);
        validateIndividualCarNames(cars);
    }

    private static void validateCarsCount(List<Car> cars) {
        if (cars.size() > 5) {
            throw new IllegalArgumentException("자동차가 너무 많습니다. 최대 5개까지 가능합니다.");
        }
    }

    private static void validateSingleCar(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException("이름이 하나만 입력되었습니다. 최소 2개 이상의 이름을 입력해야 합니다.");
        }
    }

    private static void validateIndividualCarNames(List<Car> cars){
        Set<String> uniqueNames = new HashSet<>();

        for (Car car : cars) {
            String name = car.getCarName().trim();

            validateEmptyName(name);
            validateNameLength(name);
            validateNameCharacters(name);
            validateDuplicateCarName(name, uniqueNames);
        }
    }

    private static void validateEmptyName(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("이름은 빈 문자열일 수 없습니다.");
        }
    }

    private static void validateNameLength(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름이 5자를 초과합니다: " + name);
        }
    }

    private static void validateNameCharacters(String name){
        if(!name.matches("[a-zA-Z가-힣]+")){
            throw new IllegalArgumentException("이름은 숫자나 기호, 공백을 포함할 수 없습니다: " + name);
        }
    }

    private static void validateDuplicateCarName(String name, Set<String> uniqueNames) {
        if(!uniqueNames.add(name)) {
            throw new IllegalArgumentException("이름이 중복됩니다: " + name);
        }
    }
}
