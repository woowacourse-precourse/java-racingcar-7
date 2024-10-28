package racingcar.view;

import camp.nextstep.edu.missionutils.Console;


public class InputView {
    //Function: getCarNames
    //Role: Allow user to print car names
    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    //Function: getRounds
    //Role: Allow user to pick game rounds
    public static int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}