package racingcar.model;

import java.util.ArrayList;

public class RoundRecord {

    private ArrayList<String> playersRecordByRound = new ArrayList<>();
    public void saveRoundRecord(CarPlayer carPlayer) {
        String playerRecord = carPlayer.getName() + " : " + carPlayer.getSteps();
        playersRecordByRound.add(playerRecord);
    }
}
