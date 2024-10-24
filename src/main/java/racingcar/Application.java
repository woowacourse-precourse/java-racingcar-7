package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput = Console.readLine();
        int round = Integer.parseInt(Console.readLine());
        Console.close();

        List<String> carNames = new ArrayList<>();

        try {
            isValidInput(playerInput, round);
            carNames = splitInput(playerInput);
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류 : " + e.getMessage());
        }

        RacingGame racingGame = new RacingGame(carNames, round);
        racingGame.startGame();


    }

    /**
     * 사용자 입력의 유효성 검사
     *
     * @param input 사용자로부터 입력된 문자열
     * @throws IllegalArgumentException 입력이 유효하지 않은 경우 발생
     */
    public static void isValidInput(final String input, final Integer round) {
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

        // 4. 시도 횟수가 0회 이하인 경우
        if (round <= 0) {
            throw new IllegalArgumentException("시도횟수는 최소 1회 이어야 합니다."); //예외 메세지
        }
    }

    public static List<String> splitInput(final String input) {
        return Arrays.asList(input.split(","));
    }

}
