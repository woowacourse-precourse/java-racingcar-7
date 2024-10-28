package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class GameView {

    private final Validator validator = new Validator();

    // 입력
    public HashMap<String, Integer> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        String[] str = userInput.split(",");
        HashMap<String, Integer> car = new HashMap<>();
        for(String s : str) {
            validator.nameValidation(s, car.keySet());
            car.put(s, 0);
        }

        return car;
    }

    public int inputGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = Console.readLine();
        System.out.println();
        validator.countValidation(userInput);
        return Integer.parseInt(userInput);
    }


    // 출력
    public void printGame(HashMap<String, Integer> cars) {
        for(String name: cars.keySet()) {
            System.out.print(name + " : ");
            System.out.println("-".repeat(cars.get(name)));
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
}
