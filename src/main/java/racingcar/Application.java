package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;

public class Application {
    public static HashMap<String, Integer> getUserInfo() {
        String input = Console.readLine();
        String[] StrArr_Name = input.split(",");
        int times = Integer.parseInt(Console.readLine());
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (String name:StrArr_Name) {
            scoreMap.put(name, 0);
        }
        for (int i = 0; i < times; i++) {
            for (String name:scoreMap.keySet()) {
                if (Randoms.pickNumberInRange(0,9) >= 4){
                    int step = scoreMap.get(name) + 1;
                    scoreMap.put(name, step);
                }
            }
        }

        return scoreMap;
    }

    public static void main(String[] args) {
        System.out.println(getUserInfo());

    }
}
