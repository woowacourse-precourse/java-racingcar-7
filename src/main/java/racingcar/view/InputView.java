package racingcar.view;
import camp.nextstep.edu.missionutils.Console;
import racingcar.controller.ValidateInput;

public class InputView {
    public static String carNamesInput;
    public static String numberAttempts;

    public static void receiveUserInput() {    // 사용자로부터 자동차 이름, 시도 횟수 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNamesInput = Console.readLine();
        ValidateInput.name();

        System.out.println("시도할 횟수는 몇 회인가요?");
        numberAttempts = Console.readLine();
        ValidateInput.validateAttempts();
    }

    public static String getCarNamesInput() {
        return carNamesInput;
    }

    public static String getNumberAttempts() {
        return numberAttempts;
    }
}

