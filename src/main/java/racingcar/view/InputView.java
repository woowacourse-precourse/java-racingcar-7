package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    /**
     * Get Racing Car Names From User
     * Input : X
     * Output : String
    **/
    static public String getRacingCarNameFromUser(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    /**
     * Get How Many Times to Race From User
      * Input : X
      * Output : String
     **/
    static public String getNumberOfRaceFromUser(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }
}
