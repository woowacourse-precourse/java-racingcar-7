package racingcar;

import java.util.ArrayList;
import racingcar.controller.InputHandler;

public class InputValidator {

    public static void notOneName(ArrayList<String> carNameList){
        if(InputHandler.getCarNameList().size() <= 1){
            throw new IllegalArgumentException();
        }
    }

    public static void notOverFiveLetter(ArrayList<String> carNameList) {
        for (String carName : carNameList) {
            if(carName.length() >5){
                throw new IllegalArgumentException();
            }
        }
    }

    public static void notCompleteKoreanName(ArrayList<String> carNameList) {
        for (String carName : carNameList) {
            if (!carName.matches("^[가-힣]+$")) {
                throw new IllegalArgumentException("이름에 완전한 한글 낱말이 아닌 글자가 포함되어 있습니다.");
            }
        }
    }


}
