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
    private ArrayList<RoundRecord> roundRecords = new ArrayList<>();
    private ArrayList<String> winnerList = new ArrayList<>();

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private void setVariables() {
        if (inputView.getPlayersList() != null) {
            playerCount = inputView.getPlayersList().size();
        }
        roundCount = inputView.getTrial();
    }

    private void setCarPlayersList() {
        for (int i = 0; i < playerCount; i++) {
            CarPlayer carPlayer = new CarPlayer();
            carPlayer.setName(inputView.getPlayersList().get(i));
            carPlayers.add(carPlayer);
        }
    }

    private void setRoundRecordsList() {
        for (int i = 0; i < roundCount; i++) {
            RoundRecord roundRecord = new RoundRecord();
            roundRecords.add(roundRecord);
        }
    }

    private void moveCarPlayers() {
        for (int i = 0; i < roundCount; i++) {
            for (int j = 0; j < playerCount; j++) {
                carPlayers.get(j).move();
                roundRecords.get(i).saveRoundRecord(carPlayers.get(j));
            }
        }
    }

    private void selectWinner() {
        int max = 0;
        for (int i = 0; i < playerCount; i++) {
            int stepCount = carPlayers.get(i).getStepCount();
            if (stepCount > max) {
                max = stepCount;
            }
        }

        for (int i = 0; i < playerCount; i++) {
            if (carPlayers.get(i).getStepCount() == max) {
                winnerList.add(carPlayers.get(i).getName());
            }
        }
    }

    public void start() {
        inputView.inputGameInfo();

        setVariables();
        setCarPlayersList();
        setRoundRecordsList();
        moveCarPlayers();
        selectWinner();

        outputView.setGameResult(roundRecords);
        outputView.setGameRound(roundCount);
        outputView.setGameWinner(winnerList);
        outputView.printGameResult();
    }
}
