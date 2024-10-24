package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String getUserInput(){
        return Console.readLine();
    }
    public static String getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return getUserInput();
    }
    public static String getAttemptCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return getUserInput();
    }
}
