package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    private static final String DELIMITER = ",";

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();
        List<String> carNames = List.of(inputNames.split(DELIMITER));

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRaceTime = Console.readLine();
        int raceTime = Integer.parseInt(inputRaceTime);
    }
}
