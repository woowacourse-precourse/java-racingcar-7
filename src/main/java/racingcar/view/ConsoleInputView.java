package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 콘솔로 입력값을 다루는 클래스
 * 입력값을 받아서 CarController에게 전달한다.
 */
public class ConsoleInputView implements InputView {

    private static final Pattern carNamePattern =
            Pattern.compile("^[0-9a-zA-Z가-힣]{1,5}(,[0-9a-zA-Z가-힣]{1,5})*$");

    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesToValidate = Console.readLine();
        validateNameFormat(carNamesToValidate);
        return carNamesToValidate;
    }

    @Override
    public int getChanceToMove() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String chanceInputToValidate = Console.readLine();
        validateNumberFormat(chanceInputToValidate);
        return Integer.parseInt(chanceInputToValidate);
    }

    private void validateNameFormat(String nameToValidate) {
        Matcher matcher = carNamePattern.matcher(nameToValidate);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름 형식이 아닙니다.");
        }
    }

    private void validateNumberFormat(String numberToValidate) {
        validateNotBlank(numberToValidate);
        validateOnlyDigit(numberToValidate);
        validateNotZero(numberToValidate);
    }

    private void validateNotBlank(String numberToValidate) {
        if (numberToValidate.isEmpty()) {
            throw new IllegalArgumentException("문자열이 공백입니다. 숫자를 입력하세요.");
        }
    }

    private void validateOnlyDigit(String numberToValidate) {
        try {
            Integer.parseInt(numberToValidate);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나 int 범위를 벗어납니다.");
        }
    }

    private void validateNotZero(String numberToValidate) {
        int number = Integer.parseInt(numberToValidate);
        if (number == 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 양수이어야 합니다.");
        }
    }


}
