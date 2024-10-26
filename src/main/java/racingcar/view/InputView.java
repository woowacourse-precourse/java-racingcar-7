package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.UserInputData;

public class InputView {
    public static String readStrings() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputStrings = Console.readLine();
        validateEmptyString(inputStrings);

        return inputStrings;
    }

    public static int readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine();
        validateEmptyOrZeroTryCount(tryCount);
        validateNotNumber(tryCount);

        return Integer.parseInt(tryCount);
    }

    private static void validateEmptyString(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("빈값을 입력하셨습니다. 이름을 입력해주세요");
        }
    }

    private static void validateNotNumber(String tryCount) {
        String rex = "[^\\d]+";
        Pattern pattern = Pattern.compile(rex);
        Matcher matcher = pattern.matcher(tryCount);

        if (matcher.find()) {
            throw new IllegalArgumentException("시도횟수는 양수만 입력할 수 있습니다.");
        }
    }

    private static void validateEmptyOrZeroTryCount(String inputString) {
        if (inputString.isBlank() || inputString.equals("0")) {
            throw new IllegalArgumentException("0또는 빈 값을 입력하셨습니다.");
        }
    }
}
