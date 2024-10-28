package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] names = getNames();
        int tryCount = getTryCount();
        Map<String, boolean[]> playerGameHistory = simulateFullRace(names, tryCount);
        printResult(tryCount, playerGameHistory);
    }

    private static String[] getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 잘못 입력 하셨습니다.");
            }
        }
        return names;
    }

    private static void printResult(int tryCount, Map<String, boolean[]> playerGameHistory) {
        printRaceResults(tryCount, playerGameHistory);
        printWinner(playerGameHistory);
    }

    private static void printRaceResults(int tryCount, Map<String, boolean[]> playerGameHistory) {
        System.out.println("\n실행 결과");
        Map<String, String> playerResults = new HashMap<>();
        for (int i = 0; i < tryCount; i++) {
            printPlayerResult(playerGameHistory, i, playerResults);
            System.out.println();
        }
    }

    private static void printPlayerResult(Map<String, boolean[]> playerGameHistory, int index,
            Map<String, String> playerResults) {
        for (String player : playerGameHistory.keySet()) {
            boolean[] gameWinHistory = playerGameHistory.get(player);
            if (gameWinHistory[index]) {
                playerResults.put(player, playerResults.getOrDefault(player, "") + "-");
            }
            System.out.printf("%s : %s \n", player, playerResults.getOrDefault(player, ""));
        }
    }

    private static void printWinner(Map<String, boolean[]> playerGameHistory) {
        int max = getMax(playerGameHistory);
        List<String> winners = getWinners(playerGameHistory, max);
        System.out.printf("최종 우승자 : %s", String.join(", ", winners));
    }

    private static int getMax(Map<String, boolean[]> playerGameHistory) {
        int max = Integer.MIN_VALUE;
        for (boolean[] result : playerGameHistory.values()) {
            int trueCount = getCount(result);
            max = Math.max(max, trueCount);
        }
        return max;
    }

    private static List<String> getWinners(Map<String, boolean[]> playerGameHistory, int max) {
        List<String> winners = new ArrayList<>();
        for (String player : playerGameHistory.keySet()) {
            int count = getCount(playerGameHistory.get(player));
            if (max == count) {
                winners.add(player);
            }
        }
        return winners;
    }

    private static int getCount(boolean[] result) {
        return (int) IntStream.range(0, result.length)
                .filter(i -> result[i])
                .count();
    }


    private static Map<String, boolean[]> simulateFullRace(String[] names, int tryCount) {
        Map<String, boolean[]> playerGameHistory = initGameHistory(names, tryCount);

        for (String player : playerGameHistory.keySet()) {
            boolean[] gameWinHistory = playerGameHistory.get(player);
            simulatePlayerRace(tryCount, gameWinHistory);
        }
        return playerGameHistory;
    }

    private static void simulatePlayerRace(int tryCount, boolean[] gameWinHistory) {
        for (int i = 0; i < tryCount; i++) {
            int randomValue = pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                gameWinHistory[i] = true;
            }
        }
    }

    private static Map<String, boolean[]> initGameHistory(String[] names, int tryCount) {
        Map<String, boolean[]> playerGameHistory = new HashMap<>();
        for (String name : names) {
            playerGameHistory.put(name, new boolean[tryCount]);
        }
        return playerGameHistory;
    }

    private static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine());
    }


}
