package racingcar;

import java.util.ArrayList;
import racingcar.controller.InputHandler;
import racingcar.view.InputView;

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

    public static void notUseComma(String CarName){
        if(!CarName.contains(",")){
            throw new IllegalArgumentException("서로 다른 자동차 이름의 구분자로 쉼표(,)를 사용해야 합니다.");
        }
    }

    public static void notWriteLetter(ArrayList<String> carNameList){
        for (String carName : carNameList) {
            if(carName.isEmpty()){
                throw new IllegalArgumentException("구분자(,) 옆에 자동차 이름을 작성해야 합니다.");
            }
        }
    }
}
