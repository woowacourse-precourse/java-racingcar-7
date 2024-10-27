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


}