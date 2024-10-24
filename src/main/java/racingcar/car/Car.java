package racingcar.car;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ddaerae
 * 자동차와 관련된 기능이 모이는 유틸리티 클래스
 */
public class Car {

    // 요구 사항 먼저 구현해보기

    // 자동차의 이름과 전진횟수를 넣을 수 있는 객체를 리턴함
    static List<Map<String,String>> getCarNameAndGoCountList(String inputValue) {
        return Arrays.stream(inputValue.split(",")).map(Car::validateForCarName).toList();
    }

    static Map<String,String> validateForCarName(String carName) {
        if (carName != null && !carName.isEmpty() && carName.length() <= 5) {
            var carNameAndGoCount = new HashMap<String, String>();
            carNameAndGoCount.put(carName,"");
            return carNameAndGoCount;
        } else if(carName != null && carName.length() > 5) {
            throw new IllegalArgumentException("자동차명은 5글자를 넘을 수 없습니다.");
        } else {
            throw new IllegalArgumentException("자동차 명이 정상적이지 못합니다. 입력 값을 확인하세요");
        }
    }




    // 차량의 정지, 혹은 전진 여부를 판단하여 문자열을 리턴한다.
    public static String goOrStop(int ranNum) {
        if (ranNum >= 4) {
            return "-";
        } else {
            return "";
        }
    }

    public static void specialCharValidation(String inputVal) {
        boolean isContainAnotherSpecialChar = inputVal.matches(".*[^,a-zA-Z].*");

        if(isContainAnotherSpecialChar){
            throw new IllegalArgumentException("특수기호는 , 외에 사용하면 안됩니다.");
        }
    }

    // 특수기호 유효성검사를 마치고 공백 제거 및 길이 확인
    public static List<String> splitAndNameValidation(String inputVal) {
        List<String> trimCarNameList = Arrays.stream(inputVal.split(",")).map(String::trim).toList();

        for (int i = 0; i < trimCarNameList.size(); i++) {
            if (trimCarNameList.get(i).length() > 5) {
                throw new IllegalArgumentException("이름은 다섯글자를 넘을 수 없습니다.\n " +
                        "잘못된 이름 : " + trimCarNameList.get(i));
            }
        }

        return trimCarNameList;
    }

    private Car() {

    }


}
