package racingcar.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    // 기존 메서드: Console에서 입력을 받습니다.
    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return parseCarNames(input);
    }

    // 새로운 메서드: 테스트용 입력을 직접 받는 메서드
    public static List<String> readCarNamesFromInput(String input) {
        return parseCarNames(input);
    }

    // 이름 목록을 쉼표로 구분하여 파싱하고, 5글자 이하인지 검증
    private static List<String> parseCarNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("차 이름은 5글자 이하이어야 합니다: " + name);
                    }
                })
                .collect(Collectors.toList());
    }

    // 시도 횟수를 입력받는 메서드
    public static int readAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseAttemptCount(input);
    }

    // 입력된 시도 횟수가 양의 정수인지 검증하고 파싱
    private static int parseAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}