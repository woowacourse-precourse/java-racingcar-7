package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;

public class GameView {
    // 입력
    private String userInput() {
        String input = Console.readLine();
        return input;
    }

    public HashMap<String, Integer> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = userInput();
        String[] str = userInput.split(",");
        HashMap<String, Integer> car = new HashMap<>();
        for(String s : str) {
            if(s.length() > 5)
                throw new IllegalArgumentException();
            if(car.containsKey(s))
                throw new IllegalArgumentException();

            car.put(s, 0);
        }

        return car;
    }

    public int inputGameCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = userInput();
        System.out.println();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
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
