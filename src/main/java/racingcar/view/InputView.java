package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;


public class InputView {
    public String getCarNamesInput(){
        System.out.println("자동차 이름들을 입력해주세요(쉼표로 구분).");
        return readLine();
    }

}
