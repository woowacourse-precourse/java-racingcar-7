package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        System.out.println("시도할 횟수는 몇 회인가요?");
        int attempts = Integer.parseInt(Console.readLine());

        Race race = new Race(carNames, attempts);
        race.start();
        race.printWinners();
    }
}
