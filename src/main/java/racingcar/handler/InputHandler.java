package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String[] inputCarNames() {
        String inputString = Console.readLine();
        String[] split = inputString.split(",");
        String[] carNames = new String[split.length];
        System.arraycopy(split, 0, carNames, 0, split.length);
        return carNames;
    }


    public int inputGameNumber() {
        int gameNumber = Integer.parseInt(Console.readLine());
        return gameNumber;
    }
}