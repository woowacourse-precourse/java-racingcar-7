package racingcar.presentation.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import racingcar.global.ErrorMessage;

public class InputView {
    private static final String INPUT_CARS_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 횟수는 몇 회인가요?";

    public String getCarNames(){
        System.out.println(INPUT_CARS_NAMES);
        return readLine();
    }

    public String getTrialCount(){
        System.out.println(INPUT_TRIAL_COUNT);
        return readLine();
    }

    private static String readLine(){
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ErrorMessage.NO_LINES_FOUND.getMessage());
        }
    }
}
