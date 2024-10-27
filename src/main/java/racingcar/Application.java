package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    static List<String> players = new ArrayList<>();
    static Map<String, Integer> playerDistanceMap = new HashMap<>();
    static int N;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Input();
            gameStart();
            finalOutput();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            throw e;
        }
    }

    private static void finalOutput() {
        List<String> finalPlayers = calculrator();
        finalPlayerPrint(finalPlayers);
    }

    private static void finalPlayerPrint(List<String> finalPlayers) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String player : finalPlayers) {
            sb.append(player + ", ");
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());
    }

    private static List<String> calculrator() {
        int max = -1;
        List<String> winPlayers = null;
        for (String player : players) {
            int distance = playerDistanceMap.get(player);
            if (max < distance) {
                max = distance;
                winPlayers = new ArrayList<>();
                winPlayers.add(player);
            } else if (max == distance) {
                winPlayers.add(player);
            }
        }
        return winPlayers;
    }

    private static void gameStart() {
        System.out.println("실행 결과");
        for (int i = 0; i < N; i++) {
            iterGame();
            iterOutPut();
        }
    }

    private static void iterOutPut() {
        for (String player : players) {
            String distance = "";
            int k = playerDistanceMap.get(player);
            for (int i = 0; i < k; i++) {
                distance += "-";
            }
            System.out.println(player + " : " + distance);
        }
        System.out.println();
    }

    private static void iterGame() {
        for (String player : players) {
            playerDistanceMap.put(player, playerDistanceMap.getOrDefault(player,0) + ramdom());
        }
    }

    private static int ramdom() {
        int r = Randoms.pickNumberInRange(0, 9);
        if(r >= 4) return 1;
        else return 0;
    }

    private static void Input() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerText = Console.readLine();
//        String playerText = "aa,bb,c";

        String[] playerArray = playerText.split(",");
        playerListInput(playerArray);

        System.out.println("시도할 횟수는 몇 회인가요?");
        N = Integer.parseInt(Console.readLine());
    }

    static void playerListInput(String[] playerArray) throws IllegalArgumentException{
        for (String player : playerArray) {
            if(players.contains(player)){
                throw new IllegalArgumentException("동일한 이름의 선수가 포함되었습니다.");
            }

            if(player.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }

            players.add(player);
        }
    }
}
