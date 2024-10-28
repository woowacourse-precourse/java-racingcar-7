package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IOManager {
    static public void carInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        input = input.trim();
        carNameInputCheck(input);

        turnInput();

        Console.close();
    }

    static private void turnInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();

        try {
            int turn = Integer.parseInt(input);

            GameManager gameManager = GameManager.getInstance();
            gameManager.setEndTurn(turn);

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    static private void carNameInputCheck(String input) {
        String[] carNames = input.split(",");

        CarManager carManager = CarManager.getInstance();

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하로 입력해주세요.");
            }
            carManager.makeCarList(name);
        }
    }

    static private void printState() {

    }

    static private void printResult() {

    }
}
