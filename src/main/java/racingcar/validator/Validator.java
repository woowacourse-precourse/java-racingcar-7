package racingcar.validator;

import racingcar.domain.Car;

public class Validator {

    public static String validateCarNameUnderFive(String carName){

        if(carName.length() > 5){
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해 주세요.");
        }

        return carName;
    }

    public static String validateCommaSeparator(String inputCarName){

        if(!inputCarName.contains(",")){
            throw new IllegalArgumentException("쉼표를 이용해서 자동차를 구분해 주세요.");
        }

        return inputCarName;
    }

    public static Integer validateNotNumber(String trialCount){

        try{
            return Integer.parseInt(trialCount);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
