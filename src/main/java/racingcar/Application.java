package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame game = new RacingGame();
        game.setupCars();
    }
}

class RacingGame {
    private List<String> carNames = new ArrayList<>();
    private int moveCount;

    public void setupCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        validateInput(input);
        parseCarNames(input);
    }


    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private void parseCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            name = name.trim();
            if (name.length() > 5 || name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1~5자 이내여야 합니다: " + name);
            }
            carNames.add(name);
        }

        System.out.println("입력된 자동차 이름: " + carNames);
    }

    public void setupMoves() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        validateMoveCount(input);
        moveCount = Integer.parseInt(input);
    }

    private void validateMoveCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이동 횟수를 입력해주세요.");
        }
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 숫자여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 숫자여야 합니다.");
        }
    }



}
