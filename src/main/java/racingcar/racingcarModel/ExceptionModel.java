package racingcar.racingcarModel;

import java.util.HashSet;
import java.util.Set;

public class ExceptionModel {

    //자동차 이름 배열 형태로 분리
    private String[] carNames(String nameInput) {
        return nameInput.split(",");
    }



    //자동차 입력 공백 확인
    public void emptyCarName(String nameInput) {
        if (nameInput == null || nameInput.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
    //자동차 입력 배열 내 공백 확인
    public void emptyCarNames(String nameInput) {
        for (String carName : carNames(nameInput)) {
            if (carName == null || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 자동차 이름이 공백 포함 5글자를 초과할 경우
    public void overFiveCarNames(String nameInput) {
        for (String name : carNames(nameInput)) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 중복된 자동차 이름이 있을 경우
    public void uniqueCarNames(String nameInput){
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames(nameInput)) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException();
            }
        }
    }






}