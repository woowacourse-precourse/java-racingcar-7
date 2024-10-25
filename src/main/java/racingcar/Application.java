package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;

public class Application {

    static String[] names;
    static HashMap<String, Integer> car;

    public static void main(String[] args) {

        String input = Console.readLine();
        Application app = new Application();
        app.init(input);

    }

    public void init(String input) {
        // ,를 delimiter로 나눠줌
        String delimiters = ",";
        names = input.split("[" + delimiters + "]");
        //현재 거리는 전부 0
        for (String name : names) {
            car.put(name, 0);
        }
    }

}
