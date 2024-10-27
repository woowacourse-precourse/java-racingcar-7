package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;

public class Input {

    public final HashMap<String, Integer> cars;
    public final int cnt;

    public Input() {
        this.cars = carNames();
        this.cnt = gameCnt();
    }

    private HashMap<String, Integer> carNames() {
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

    private int gameCnt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String userInput = userInput();
        try {
            return Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
    private String userInput() {
        String input = Console.readLine();
        return input;
    }
}
