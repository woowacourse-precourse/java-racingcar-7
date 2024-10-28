package racingcar.model;

import java.util.ArrayList;

public class RoundRecord {
    private final ArrayList<String> playersRecordByRound = new ArrayList<>();

    public void saveRoundRecord(CarPlayer carPlayer) {
        String playerRecord = carPlayer.getName() + " : " + carPlayer.getSteps();
        playersRecordByRound.add(playerRecord);
    }

    public void getRoundResult() {
        for (String playerRecord : playersRecordByRound) {
            System.out.println(playerRecord);
        }
    }
}
