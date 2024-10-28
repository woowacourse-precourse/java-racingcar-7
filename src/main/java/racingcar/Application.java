package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void showInputCarNameDialogue() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static List<String> getCarNames() {
        String names = Console.readLine();
        String [] splited = names.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : splited) {
            if (name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름으로 공백은 허용되지 않습니다.");
            }
            carNames.add(name);
        }
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("반드시 하나 이상의 자동차 이름이 필요합니다.");
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
