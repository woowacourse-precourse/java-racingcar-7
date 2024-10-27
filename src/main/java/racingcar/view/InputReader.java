package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.assertj.core.util.Arrays;
import racingcar.racing.RacingCount;

public class InputReader {

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String input = Console.readLine();
        final String[] names = input.split(",");
        return List.of(Arrays.array(names));
    }

    public RacingCount readRacingCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String input = Console.readLine();
        return new RacingCount(input);
    }
}
