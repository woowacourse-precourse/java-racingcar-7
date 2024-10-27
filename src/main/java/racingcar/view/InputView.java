package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingInfo;

public class InputView {
    private static final String INPUT_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public RacingInfo readRacingInfo() {
        return new RacingInfo(readCarNames(), readTryCount());
    }

    private String readCarNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        String carNames = Console.readLine();
        checkRacingInfoIsNull(carNames);

        return carNames;
    }

    private int readTryCount() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        String tryCount = Console.readLine();

        checkRacingInfoIsNull(tryCount);
        return convertToNumericTryCount(tryCount);
    }

    private void checkRacingInfoIsNull(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 또는 경기횟수를 입력해주세요.");
        }
    }

    private int convertToNumericTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경기횟수는 숫자를 입력해주세요.");
        }
    }
}
