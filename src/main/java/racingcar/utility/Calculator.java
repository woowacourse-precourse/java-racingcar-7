package racingcar.utility;

import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import racingcar.dto.GameResultDto;

public class Calculator {

    private static final int boundNumber = 4;

    public static boolean canMove(int randomNumber) {
        return randomNumber >= boundNumber;
    }

    public static List<String> findWinners(GameResultDto gameResultDto) {
        Map<String, Integer> gameDataMap = gameResultDto.getGameData();
        OptionalInt maxOptional = gameDataMap.values().stream().mapToInt(Integer::intValue).max();

        if (maxOptional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int maxValue = maxOptional.getAsInt();
        List<String> winners = gameDataMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .toList();
        return winners;
    }
}
