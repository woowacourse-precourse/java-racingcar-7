package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.InputFormatter.trimInput;
import static racingcar.Validator.InputValidator.*;

public class InputView {


    public static String readString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        validateCarNames(inputString);
        return trimInput(inputString);
    }

    public static int readNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNum = Console.readLine();
        validateNumber(inputNum);
        System.out.println("");
        return Integer.parseInt(inputNum);
    }

}
