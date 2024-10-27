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
    private final ArrayList<CarPlayer> carPlayerList = new ArrayList<>();
    private final ArrayList<RoundRecord> roundRecordList = new ArrayList<>();
    private final ArrayList<String> winnerList = new ArrayList<>();

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
            carPlayerList.add(carPlayer);
        }
    }

    private void setRoundRecordsList() {
        for (int i = 0; i < roundCount; i++) {
            RoundRecord roundRecord = new RoundRecord();
            roundRecordList.add(roundRecord);
        }
    }

    private void moveCarPlayers() {
        for (int i = 0; i < roundCount; i++) {
            for (int j = 0; j < playerCount; j++) {
                carPlayerList.get(j).move();
                roundRecordList.get(i).saveRoundRecord(carPlayerList.get(j));
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

    public void start() {
        inputView.inputGameInfo();

        setVariables();
        setCarPlayersList();
        setRoundRecordsList();
        moveCarPlayers();
        selectWinner();

        outputView.setGameResult(roundRecordList);
        outputView.setGameWinner(winnerList);
        outputView.printGameResult();
    }
}
