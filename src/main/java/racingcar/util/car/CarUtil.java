package racingcar.util.car;


import racingcar.vo.CarVO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ddaerae
 * 자동차와 관련된 기능이 모이는 유틸리티 클래스
 */
public class CarUtil {

    // 요구 사항 먼저 구현해보기

    // 자동차의 이름과 전진횟수를 넣을 수 있는 객체를 리턴함
    public static List<CarVO> getCarNameAndGoCountList(String inputValue) {
        return splitAndNameValidation(inputValue).stream().map(carName -> {
            var nameAndGoCount = new CarVO(carName);
            return nameAndGoCount;
        }).toList();

    }


    // 특수기호 유효성검사를 마치고 공백 제거 및 길이 확인
    public static List<String> splitAndNameValidation(String inputVal) {
        List<String> trimCarNameList = Arrays.stream(inputVal.split(","))
                .map(carName -> carName.replace(" ", "")).toList();
        boolean isContainAnotherSpecialChar = inputVal.matches(".*[^,a-zA-Z가-힣 ].*");

        if (isContainAnotherSpecialChar) {
            throw new IllegalArgumentException(", 외에 다른 특수 기호와 숫자를 사용하면 안됩니다.");
        }

        for (String carName : trimCarNameList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 다섯글자를 넘을 수 없습니다.\n " +
                        "잘못된 이름 : " + carName);
            } else if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차명은 공백이 될 수 없습니다.\n" +
                        ", 의 위치를 확인하세요");
            }
        }

        return trimCarNameList;
    }

    private CarUtil() {

    }


}
