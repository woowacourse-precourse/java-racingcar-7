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
            Pattern.compile("^[0-9a-zA-Z가-힣]{1,5}(,[0-9a-zA-Z가-힣]{1,5})*");

    @Override
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validateNameFormat(Console.readLine());
    }

    @Override
    public int getChanceToMove() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return validateNumberFormat(Console.readLine());
    }

    private String validateNameFormat(String nameToValidate) {
        Matcher matcher = carNamePattern.matcher(nameToValidate);
        if (matcher.hasMatch()) {
            return nameToValidate;
        }
        throw new IllegalArgumentException("[ERROR] 올바른 자동차 이름 형식이 아닙니다.");
    }

    private int validateNumberFormat(String numberToValidate) {
        int chance = 0;
        try {
            chance = Integer.parseInt(numberToValidate);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자가 아니거나 int 범위를 벗어납니다.");
        }
        return chance;
    }
}
