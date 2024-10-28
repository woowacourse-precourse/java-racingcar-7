package racingcar.service;

import java.util.ArrayList;
import racingcar.model.CarPlayer;
import racingcar.model.RoundRecord;

public class RacingGameService {
    private final ArrayList<CarPlayer> carPlayerList;
    private final ArrayList<RoundRecord> roundRecordList;
    private final ArrayList<String> winnerList = new ArrayList<>();

    public RacingGameService(ArrayList<CarPlayer> carPlayerList, ArrayList<RoundRecord> roundRecordList) {
        this.carPlayerList = carPlayerList;
        this.roundRecordList = roundRecordList;
    }

    private void moveCarPlayers() {
        for (RoundRecord roundRecord : roundRecordList) {
            for (CarPlayer carPlayer : carPlayerList) {
                carPlayer.move();
                roundRecord.saveRoundRecord(carPlayer);
            }
        }
    }

    private void selectWinner() {
        int max = 0;

        for (CarPlayer player : carPlayerList) {
            int stepCount = player.getStepCount();
            if (stepCount > max) {
                max = stepCount;
            }
        }

        for (CarPlayer player : carPlayerList) {
            if (player.getStepCount() == max) {
                winnerList.add(player.getName());
            }
        }
    }

    public void gameInnerLogic() {
        moveCarPlayers();
        selectWinner();
    }

    public ArrayList<RoundRecord> getRoundRecordList() {
        return roundRecordList;
    }

    public ArrayList<String> getWinnerList() {
        return winnerList;
    }
}
