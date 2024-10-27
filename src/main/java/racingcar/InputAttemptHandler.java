package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputAttemptHandler {
    public int getAttempCount(){
        System.out.print("시도할 횟수를 입력하세요. : ");
        String count = Console.readLine();
        return Integer.parseInt(count);
    }
}
