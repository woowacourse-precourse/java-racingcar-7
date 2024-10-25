package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        long attempt = Long.parseLong(Console.readLine());

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String name : carName.split(",")) {
            map.put(name, 0);
        }

        repeat(attempt, map);

    }

    public static void repeat(long attempt, Map<String, Integer> map) {
        while (attempt-- > 0) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                forwardDecision(map, entry);
            }
        }
    }

    public static void forwardDecision(Map<String, Integer> map, Map.Entry<String, Integer> entry) {
        if (randomDraw()) {
            map.put(entry.getKey(), entry.getValue() + 1);
        }
    }

    public static boolean randomDraw() {
        int n = Randoms.pickNumberInRange(0, 9);
        return n >= 4;
    }
}
