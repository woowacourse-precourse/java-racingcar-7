package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RaceService;

public class InputView {

    private final String INPUT_CAR_NAMES_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";

    public String inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_MSG);
        String carNames = Console.readLine();
        return carNames;
    }

    public int inputTryCount() {
        System.out.println(INPUT_TRY_COUNT_MSG);
        int tryCount = Integer.parseInt(Console.readLine());
        return tryCount;
    }
}
