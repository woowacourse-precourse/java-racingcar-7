package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
01. 사용자 입력 구현
    - ex) "pobi,woni,jun"
    - n명 이름 입력 받기 ➡> 구분자 검사 (쉼표 이외인 경우 예외처리 발생)
    - 유효한 구분자의 경우, n명 이름 분할 ➡> 이름 5자 이하 검사 (5자 초과인 경우 예외처리 발생)
*/

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        try {
            isValidInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류 : " + e.getMessage());
            return;
        }

        Console.close();
    }

    /**
     * 사용자 입력의 유효성을 검사합니다.
     *
     * @param input 사용자로부터 입력된 문자열
     * @throws IllegalArgumentException 입력이 유효하지 않은 경우 발생
     */
    public static void isValidInput(final String input) {
        // 1. 입력이 빈 문자열 또는 null 인 경우
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다."); // 예외 메시지
        }

        // 2. 쉼표로 구분되지 않은 경우
        if (!input.contains(",")) {
            throw new IllegalArgumentException("이름은 쉼표로 구분되어야 합니다."); // 예외 메시지
        }

        // 3. 사용자 이름이 비어있거나 5자 이상인 경우
        List<String> usernames = new ArrayList<>(Arrays.asList(input.split(",")));
        for (String username : usernames) {
            if (username.isEmpty()) {
                throw new IllegalArgumentException("이름은 공백일 수 없습니다."); // 예외 메시지
            }
            if (username.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이내이어야 합니다."); // 예외 메시지
            }
        }
    }
}
