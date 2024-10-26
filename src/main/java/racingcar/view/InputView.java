package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.InputValidator;

import static racingcar.model.ViewMessage.CAR_NAMES_MESSAGE;
import static racingcar.model.ViewMessage.TRY_NUMBER_MESSAGE;

public class InputView {

    // 입력
    public static String inputCarNames() {
        System.out.println(CAR_NAMES_MESSAGE);
        String input = Console.readLine().trim();

        InputValidator.validateCharacter(input); // 문자열에 알맞지 않는 문자 여부 검증
        InputValidator.validateNotEmpty(input); // 문자열 공백인지 검증

        return input;
    }

    public static int inputTryNumber() {
        System.out.println(TRY_NUMBER_MESSAGE);
        String tryNumber = Console.readLine().trim();

        InputValidator.validateInteger(tryNumber); // 시도 횟수가 숫자인지 검증

        return Integer.parseInt(tryNumber);
    }
}