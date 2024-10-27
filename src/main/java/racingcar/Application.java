package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundInput = Console.readLine();

        List<String> names = Arrays.stream(carNameInput.split(","))
                .map(String::trim)
                .toList();

        int round = Integer.parseInt(roundInput);

        RacingManager manager = new RacingManager(names, round);
        manager.startRace();
        manager.printResult();
    }
}
