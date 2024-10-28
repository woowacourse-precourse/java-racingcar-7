package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String input = Console.readLine();
        validateNames(input);

        System.out.print("시도할 횟수는 몇 회인가요?: ");
        String attemptsInput = Console.readLine();
        int attempts = validateAttempts(attemptsInput);

        System.out.println("입력된 이름들: " + input);
        System.out.println("시도할 횟수: " + attempts);
    }

}
