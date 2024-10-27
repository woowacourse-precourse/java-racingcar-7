package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strPlayer = Console.readLine();
        InputValidator.validatePlayer(strPlayer);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String strRound = Console.readLine();
        InputValidator.validateRound(strRound);
    }
}
