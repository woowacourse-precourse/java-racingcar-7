package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println(input);

        String[] carNames = null;
        try {
            carNames = splitNames(input);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            throw e;
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int moveCount = Integer.parseInt(Console.readLine());
        System.out.println(moveCount);

        if (carNames != null) {
            RacingGo game = new RacingGo(List.of(carNames), moveCount);
            game.play();
        }
    }

    static String[] splitNames(String input) {
        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();  // Trim each car name to remove extra spaces
            if (carNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다!");
            }
        }

        return carNames;
    }
}

