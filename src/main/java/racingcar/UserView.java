package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserView {
    public static String readCarName(){
        printCarNameGuide();
        return readLine();
    }
    private static void printCarNameGuide(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}