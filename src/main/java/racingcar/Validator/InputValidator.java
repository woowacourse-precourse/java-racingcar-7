package racingcar.Validator;

import java.util.Arrays;
import java.util.List;

public class InputValidator {



    public static void checkEmptyInput(String inputString) {
        if (inputString.isBlank()) {
            throw new IllegalArgumentException("빈 값을 입력하였습니다");
        }
    }

    public static boolean checkInputFormat(String inputString) {
        List<String> carList = Arrays.stream(inputString.split(","))
                .map(String::trim)
                .toList();

        for (String car : carList) {
            if (car.isEmpty() || !car.chars().allMatch(Character::isLetterOrDigit)) {
                return false;
            }
        }
        return true;
    }

    // 이름은 5자 이하여야 한다
    public static boolean checkInputRule(String inputString){
        List<String> carList = Arrays.stream(inputString.split(","))
                .map(String::trim)
                .toList();
        for (String car : carList) {
            if(car.length() > 5){
                return false;
            }
        }
        return true;
    }


    //숫자인지 확인하는 메서드
    public static boolean isNumber(String inputNum){
        for (char c : inputNum.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }


}
