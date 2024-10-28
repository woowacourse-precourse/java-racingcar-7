package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarRace {
    public static final int MOVE_FORWARD = 4;

    public static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }

    public static List<String> getPlayerList(String text) {
        List<String> players = Stream.of(text.split(",")).map(String::trim).peek(s -> {
            if (s.length() >= 5) {
                throw new IllegalArgumentException("이름이 5자 이상입니다.");
            }
        }).toList();
        return players;
    }
    public static void updatePlayerStatus(Map<String, Integer> playerStatus) {
        for (String player : playerStatus.keySet()) {
            int randomValue = pickNumberInRange(0, 9);
            if (randomValue >= MOVE_FORWARD) {
                playerStatus.put(player, playerStatus.get(player) + 1);
            }
        }
    }
    public static void printRaceStatus(Map<String, Integer> playerStatus) {
        playerStatus.forEach((player, position) ->
                System.out.println(player + " : " + "-".repeat(position))
        );
        System.out.println();
    }

    public static void findWinner(Map<String, Integer> playerStatus) {
        Integer maxMove = playerStatus.values().stream().max(Integer::compare).orElse(0);
        String winner = playerStatus.entrySet().stream()
                .filter(i -> i.getValue().equals(maxMove))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));// 쉼표로 구분하여 단일 문자열 생성
        System.out.println("최종 우승자 : "  + winner);
    }
}