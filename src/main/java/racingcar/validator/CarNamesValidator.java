package racingcar.validator;

import java.util.ArrayList;

public class CarNamesValidator {

    public static void validate(ArrayList<String> carNames) {
        validateNotEmptyInput(carNames);
        validateCarNameNotEmpty(carNames);
        validateLength(carNames);
        validateDuplication(carNames);

    }

    private static  void validateNotEmptyInput(ArrayList<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }

        if (carNames.size() == 1 && carNames.getFirst().trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    private static void validateCarNameNotEmpty(ArrayList<String> carNames){
        for( String carName: carNames){
            if (carName.trim().isEmpty()){
                throw new IllegalArgumentException("자동차 이름이 공백입니다.");
            }
        }
    }

    private static void validateLength(ArrayList<String> carNames) {
        for ( String carName : carNames ) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("5글자를 초과하는 자동차 이름이 존재합니다.");
            }
        }
    }

    private static void validateDuplication(ArrayList<String> carNames) {
        if(carNames.size() != carNames.stream().distinct().count()){
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

}
