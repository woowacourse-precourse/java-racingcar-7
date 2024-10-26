package racingcar.validator;

import racingcar.domain.Car;

public class Validator {

    public static String validateCarNameUnderFive(String carName){

        if(carName.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요.");
        }

        return carName;
    }
}
