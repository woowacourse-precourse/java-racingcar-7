package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;
import racingcar.utils.ErrorMessage;

public class InputView {
    private static final String GET_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_NUMBERS = "시도할 회수는 몇회인가요?";

    public String getCarNames() throws IOException {
        System.out.println(GET_CAR_NAMES);
        return Console.readLine();
    }

    public int getTryNumbers() throws IOException {
        System.out.println(GET_TRY_NUMBERS);
        return validateTrialNumber(Integer.parseInt(Console.readLine()));
    }

    private int validateTrialNumber(int trials) {
        try {
            if (trials < 1) {
                throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_UNDER_RANGE.message());
            }
            if (trials > 100) {
                throw new IllegalArgumentException(ErrorMessage.TRIAL_NUMBER_OVER_RANGE.message());
            }
            return trials;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRIAL_NUMBER.message());
        }
    }
}
