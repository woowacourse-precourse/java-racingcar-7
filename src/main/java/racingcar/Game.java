package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = List.of(Console.readLine().split(","));
        System.out.println("시도할 회수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        // TODO: 횟수 입력 검증


    }
}
