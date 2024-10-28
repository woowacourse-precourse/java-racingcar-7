package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.RacingCarResult;
import racingcar.model.RacingTrialLog;

public class RacingCarService {
    public RacingCarResult runRacingCar(List<String> carNames, int trialNum) {
        Map<String, Integer> carProgressMap = new HashMap<>();
        for (String name : carNames) {
            carProgressMap.put(name, 0);
        }

        List<RacingTrialLog> racingCarLog = new ArrayList<>();

        for (int i = 0; i < trialNum; i++) {
            List<Integer> progressList = new ArrayList<>();

            for (String name : carNames) {
                int randomNumber = generateRandomNumber();
                if (checkMovementPossible(randomNumber)) {
                    int newProgress = carProgressMap.get(name) + 1;
                    carProgressMap.put(name, newProgress);
                }

                progressList.add(carProgressMap.get(name));
            }

            racingCarLog.add(RacingTrialLog.map(
                carNames,
                progressList
            ));
        }

        int maxProgress = carProgressMap.values().stream().max(Integer::compare).orElse(0);
        List<String> winners = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carProgressMap.entrySet()) {
            if (entry.getValue() == maxProgress) {
                winners.add(entry.getKey());
            }
        }

        return RacingCarResult.map(
            racingCarLog,
            winners
        );
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean checkMovementPossible(int number) {
        return number >= 4;
    }
}
