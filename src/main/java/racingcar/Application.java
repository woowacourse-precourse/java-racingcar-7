package racingcar;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void showInputCarNameDialogue() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static List<String> getCarNames() {
        String names = Console.readLine();
        String [] splited = names.split(",");
        List<String> carNames = new ArrayList<>();
        for (int i = 0 ; i < splited.length ; i++) {
            String name = splited[i];
            if (name.isBlank()) {
                throw new IllegalArgumentException("사람 이름으로 공백은 허용되지 않습니다.");
            }
            carNames.add(name);
        }
        return carNames;
    }
    public static void showInputNumberOfTurnDialogue() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static int getNumberOfTurn() {
        String number = Console.readLine().trim();
        return Integer.parseInt(number);
    }
    public static void main(String[] args) {
        showInputCarNameDialogue();
        List<String> names = getCarNames();
        showInputNumberOfTurnDialogue();
        int numberOfTurn = getNumberOfTurn();
        CarGame game = GameFactory.of(names, numberOfTurn);
        game.play();
    }
}
