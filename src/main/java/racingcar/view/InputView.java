package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/*
* 자동차 이름과 시도 횟수를 입력 받는 기능을 수행하는 클래스
 */
public class InputView {

    public static String userInputCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    
    // 시도 횟수를 입력 받는 함수
    public static String userInputCount() {
        return Console.readLine();
    }

}
