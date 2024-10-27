package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputHandler {

    public abstract String[] inputRacerNames();

    public int inputRepeatNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
        System.out.println();
        return num;
    }
}
