package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarPlayer;
import racingcar.model.RoundRecord;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private int playerCount;
    private int roundCount;
    private final InputView inputView;
    private final OutputView outputView;
    private ArrayList<CarPlayer> carPlayers = new ArrayList<>();
    private ArrayList<RoundRecord> roundRecords = new ArrayList<RoundRecord>();

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private void setVariables() {
        if(inputView.getPlayersList() != null) {
            playerCount = inputView.getPlayersList().size();
        }
        roundCount = inputView.getTrial();
    }

    private void setCarPlayersList() {
        for(int i=0; i<playerCount; i++) {
            CarPlayer carPlayer = new CarPlayer();
            carPlayer.setName(inputView.getPlayersList().get(i));
            carPlayers.add(carPlayer);
        }
    }

    private void setRoundRecordsList() {
        for(int i=0; i<roundCount; i++) {
            RoundRecord roundRecord = new RoundRecord();
            roundRecords.add(roundRecord);
        }
    }

    private void moveCarPlayers() {
        for(int i=0; i<roundCount; i++) {
            for(int j=0; j<playerCount; j++) {
                carPlayers.get(j).move();
                roundRecords.get(i).saveRoundRecord(carPlayers.get(j));
            }
        }
    }

    public void start() {
        inputView.inputGameInfo();
        setVariables();
        setCarPlayersList();
        setRoundRecordsList();
        moveCarPlayers();
    }

}
