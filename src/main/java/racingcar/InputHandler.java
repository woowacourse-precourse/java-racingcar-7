package racingcar;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    private static final String CAR_NAME_DELIMITER = ",";

    public List<CarName> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(CAR_NAME_DELIMITER);
        return Arrays.stream(carNames)
                .map(CarName::new)
                .toList();
    }

    public TryCount inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return TryCount.of(Console.readLine());
    }
}
