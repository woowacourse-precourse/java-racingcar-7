package racingcar.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerService {
    private static WinnerService winnerService;

    private WinnerService() {}

    public static WinnerService getWinnerServiceInstance() {
        if (winnerService == null) {
            winnerService = new WinnerService();
            return winnerService;
        }
        return winnerService;
    }

    public List<String> judgeWinner(Map<String, Integer> racingCars) {
        Integer maxValue = Collections.max(racingCars.values());
        List<String> winners = new LinkedList<>();

        for (Entry<String, Integer> entry : racingCars.entrySet()) {
            String carName = entry.getKey();
            Integer carPosition = entry.getValue();

            if(carPosition.equals(maxValue)) {
                winners.add(carName);
            }
        }

        return winners;
    }
}
