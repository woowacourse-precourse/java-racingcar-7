package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    private final static int MOVING_FORWARD_POINT = 4;
    private Map<String, List<Boolean>> record;
    private final RandomGenerator randomGenerator;
    private final RacePreparation racePreparation;

    public Race(RacePreparation racePreparation, RandomGenerator randomGenerator) {
        this.racePreparation = racePreparation;
        this.randomGenerator = randomGenerator;
        initialize(racePreparation.getCarNames());
    }

    private void initialize(List<String> carNames) {
        record = new HashMap<>();
        for (String name : carNames) {
            record.putIfAbsent(name, new ArrayList<>());
        }
    }

    public void startRacingGame() {
        for (int i = 0; i < racePreparation.getMatchCount(); i++) {
            record.forEach((carName, moveForwardList) -> {
                record.get(carName).add(moveForward());
                print(carName, moveForwardList);
            });
        }
    }

    private boolean moveForward() {
        int random = randomGenerator.pickNumberInRange(0, 9);
        return random >= MOVING_FORWARD_POINT;
    }

    private void print(String carName, List<Boolean> moveForwardList) {
        int repeatHyphen = (int) moveForwardList.stream().filter(val -> val).count();
        System.out.println(carName + " : " + "-".repeat(repeatHyphen));
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int max = 0;
        for (Map.Entry<String, List<Boolean>> record : record.entrySet()) {
            String carName = record.getKey();
            int forwardCnt = (int) record.getValue().stream().filter(val -> val).count();

            if (forwardCnt > max) {
                winners.clear();
                winners.add(carName);
                max = forwardCnt;
            } else if (forwardCnt == max) {
                winners.add(carName);
            }
        }
        return winners;
    }
}
