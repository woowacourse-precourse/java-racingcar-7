package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;

public class Prompt {
    public String input() {
        return Console.readLine();
    }

    public int racingTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void resultPrint(String output) {
        System.out.println(output);
        Console.close();
    }
    /**
     * TODO - 레이싱 카 이동 거리 출력 메서드
     */
}