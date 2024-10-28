package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
public class InputVIew {
    public static String getRacerName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input;
    }

    public static int getAttemptTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptTime = Integer.parseInt(Console.readLine());
        return attemptTime;
    }
}
