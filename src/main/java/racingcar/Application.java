package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();

        // 사용자 입력을 받기 위한 루프
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String carNamesInput = Console.readLine();
                System.out.println("시도할 횟수는 몇 회인가요?");
                String attemptsInput = Console.readLine();

                // 입력 처리
                inputManager.processInput(carNamesInput, attemptsInput);

                // 입력 처리 후 게임 종료
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}
