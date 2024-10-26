package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarsFactory {

    private static final String DUPLICATED_NAME = "각 차는 한번만 입력해야 합니다";
    private static final String OUT_OF_RANGE_NAME = "차는 다섯글자 이하이어야 합니다";
    private static final String BLANK_NAME="차 이름은 공백일 수 없습니다";

    private static final String SPLITOR = ",";
    private static final Integer LONGEST_NAME_LENGTH = 5;

    public static List<Car> makeCarList(String carsInput) {
        carsInput= removeBlank(carsInput);

        validateBlankName(carsInput);
        validateDuplicatedName(carsInput);
        validateOutOfRangeName(carsInput);

        List<Car> carList = Arrays.stream(carsInput.split(SPLITOR))
                .map(carName -> new Car(carName, ""))
                .toList();

        return carList;
    }

    private static void validateBlankName(String carsInput) {
        boolean hasBlank=Arrays.stream(carsInput.split(SPLITOR))
                .anyMatch((car)->car.isBlank());

        if (hasBlank){
            throw new IllegalArgumentException(BLANK_NAME);
        }
    }

    private static String removeBlank(String carsInput) {
        return carsInput.replace(" ","");
    }

    private static void validateDuplicatedName(String carsInput) {
        long before = carsInput.split(SPLITOR).length;

        long after = Arrays.stream(carsInput.split(SPLITOR)).
                distinct().
                count();

        if (before != after) {
            throw new IllegalArgumentException(DUPLICATED_NAME);
        }
    }

    private static void validateOutOfRangeName(String carsInput) {
        boolean hasOutOfRangeName = Arrays.stream(carsInput.split(SPLITOR))
                .anyMatch((car) -> car.length() > LONGEST_NAME_LENGTH);

        if (hasOutOfRangeName) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NAME);
        }
    }
}
