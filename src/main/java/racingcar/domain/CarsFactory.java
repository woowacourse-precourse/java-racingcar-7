package racingcar.domain;

import java.util.Arrays;

public class CarsFactory {

    private static final String DUPLICATED_NAME = "각 차는 한번만 입력해야 합니다";
    private static final String OUT_OF_RANGE_NAME = "차는 다섯글자 이하이어야 합니다";
    private static final String BLANK_NAME="차 이름은 공백일 수 없습니다";

    private static final String SPLITOR = ",";
    private static final Integer HIGHEST_NAME_LENGTH = 5;

    public static String validateInput(String carsInput){
        carsInput= removeBlank(carsInput);
        validateBlankName(carsInput);
        validateDuplicatedName(carsInput);
        validateOutOfRangeName(carsInput);

        return carsInput;
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
        boolean result = Arrays.stream(carsInput.split(SPLITOR))
                .anyMatch((car) -> car.length() > HIGHEST_NAME_LENGTH);

        if (result) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NAME);
        }
    }
}
