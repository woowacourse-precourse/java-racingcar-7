package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {

    // 자동차 이름 입력 받기
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        List<String> namesList = Arrays.asList(carNames.split(","));
        validateCarNames(namesList);
        return namesList;
    }

    // 시도 횟수 입력 받기
    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine().trim();
        int attempts = parseAttempts(input);
        validateAttempts(attempts);
        return attempts;
    }

    // Console 닫기
    public static void closeConsole() {
        Console.close();
    }

    // 자동차 이름 검증
    private static void validateCarNames(List<String> names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
            }
        }
    }

    // 시도 횟수 검증
    private static void validateAttempts(int attempts) {
        if (attempts < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상이어야 합니다.");
        }
    }

    // 문자열을 정수로 변환
    private static int parseAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }
}
