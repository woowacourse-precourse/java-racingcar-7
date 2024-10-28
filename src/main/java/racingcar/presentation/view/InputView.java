package racingcar.presentation.view;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final Pattern NAME_INPUT = Pattern.compile("[\\wㄱ-ㅎ가-힣_,]+");

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputLine = readInputLine();
        validateNameInputPattern(inputLine);
        return inputLine;
    }

    public String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String inputLine = readInputLine();
        validateNumeric(inputLine);
        return inputLine;
    }

    public void closeConsole() {
        Console.close();
    }

    private String readInputLine() {
        try {
            String inputLine = Objects.requireNonNull(Console.readLine());
            validateEmpty(inputLine);
            validateContainsBlank(inputLine);
            return inputLine;
        } catch (NullPointerException | NoSuchElementException e) {
            throw new RuntimeException("시스템 장애로 프로그램을 종료합니다. 다시 실행해 주세요.", e);
        }
    }

    private void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해 주세요.");
        }
    }

    private void validateContainsBlank(final String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백을 빼고 입력해주세요.");
        }
    }

    private void validateNameInputPattern(final String input) {
        if (!NAME_INPUT.matcher(input)
                .matches()
        ) {
            throw new IllegalArgumentException("이름은 한글, 숫자, 알파벳 대소문자, 언더바(_), 쉼표(,)만 입력할 수 있습니다");
        }
    }

    private void validateNumeric(final String input) {
        if (input.chars()
                .anyMatch(Character::isLetter)
        ) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        }
    }

}
