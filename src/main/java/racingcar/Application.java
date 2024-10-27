package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingGame game = new RacingGame();
        game.setupCars();
        game.setupMoves();
        game.startRace();
    }
}

class RacingGame {
    private List<String> carNames = new ArrayList<>();
    private int moveCount;
    private Map<String, Integer> carDistances = new HashMap<>();

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
            carDistances.put(name, 0);
        }
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

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            System.out.println("차수 " + (i + 1) + " 결과:");
            moveCars();
            printCarPositions();
        }
        announceWinner();
    }

    private void moveCars() {
        for (String carName : carNames) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                carDistances.put(carName, carDistances.get(carName) + 1);
            }
        }
    }

    private void printCarPositions() {
        for (String carName : carNames) {
            StringBuilder position = new StringBuilder();
            int distance = carDistances.get(carName);
            for (int j = 0; j < distance; j++) {
                position.append("-");
            }
            System.out.println(carName + " : " + position);
        }
    }

    private void announceWinner() {
        int maxDistance = carDistances.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : carDistances.entrySet()) {
            if (entry.getValue() == maxDistance) {
                winners.add(entry.getKey());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }


}