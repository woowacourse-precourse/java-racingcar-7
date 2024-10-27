package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputHandler {

    public abstract String[] inputRacerNames();

    public int inputRepeatNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int num = convertToInt(input);
        System.out.println();
        return num;
    }

    public int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}
