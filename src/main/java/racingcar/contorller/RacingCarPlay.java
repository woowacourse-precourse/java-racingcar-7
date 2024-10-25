package racingcar.contorller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.PrintMessage;

public class RacingCarPlay {

    private static PrintMessage mes = new PrintMessage();

    public static void play() {
        System.out.println(mes.startMessage);
        String input = Console.readLine();
        InputValidator.nullValidate(input);
        String[] carNames = input.split(",");
        InputValidator.lenValidate(carNames);
        System.out.println(mes.attemptsGameMessage);
        int attempts = Integer.parseInt(Console.readLine());
        InputValidator.attemptsValidate(attempts);
    }
}
