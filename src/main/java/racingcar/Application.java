package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
            boolean[] gameWinHistory = playerGameHistory.get(player);
            for (int i = 0; i < tryCount; i++) {
                int randomValue = pickNumberInRange(0, 9);
                if(randomValue >= 4) {
                    gameWinHistory[i] = true;
                }
            }
        }

        System.out.println("\n실행 결과");
        Map<String, String> playerResults = new HashMap<>();
        for (int i = 0; i < tryCount; i++) {
            for(String player : playerGameHistory.keySet()) {
                boolean[] gameWinHistory = playerGameHistory.get(player);
                if(gameWinHistory[i]) {
                    playerResults.put(player, playerResults.getOrDefault(player, "") + "-");
                }
                System.out.printf("%s : %s \n", player, playerResults.getOrDefault(player, ""));
            }
            System.out.println();
        }

        int max = Integer.MIN_VALUE;
        for(String result : playerResults.values()) {
            max = Math.max(max, result.length());
        }

        List<String> winners = new ArrayList<>();
        for(String player : playerResults.keySet()) {
            int count = playerResults.get(player).length();
            if(max == count) winners.add(player);
        }
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));








        
        







    }
}
