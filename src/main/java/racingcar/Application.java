package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(readLine());

        Map<String, boolean[]>  playerGameHistory = new HashMap<>();
        for(String name : names.split(",")) {
            playerGameHistory.put(name, new boolean[tryCount]);
        }

        for(String player : playerGameHistory.keySet()) {
            boolean[] playerHistory = playerGameHistory.get(player);
            for (int i = 0; i < tryCount; i++) {
                int randomValue = pickNumberInRange(0, 9);
                if(randomValue >= 4) {
                    playerHistory[i] = true;
                }
            }
        }








        
        







    }
}
