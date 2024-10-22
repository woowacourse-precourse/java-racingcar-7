package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class Application {
    public static HashMap<String, Object> getUserInfo() {
        String input = Console.readLine();
        int times = Integer.parseInt(Console.readLine());
        String[] StrArr_Name = input.split(",");

        HashMap<String, Object> scoreMap = new HashMap<String, Object>();
        for (String name:StrArr_Name) {
            scoreMap.put(name, 0);
        };
        return scoreMap;

    }

    public static void main(String[] args) {
        getUserInfo();
    }
}
