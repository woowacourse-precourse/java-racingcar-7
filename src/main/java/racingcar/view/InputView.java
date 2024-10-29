package racingcar.view;

import static racingcar.service.InputValidator.validInputCharacter;
import static racingcar.service.InputValidator.validInputEmpty;
import static racingcar.service.InputValidator.validInputRaceCount;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputPlayer() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validInputEmpty(input);
        validInputCharacter(input);
        return input;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int raceCount = Integer.parseInt(input);
        validInputRaceCount(raceCount);
        return raceCount;
    }
}
