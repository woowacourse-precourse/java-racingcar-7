package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarPlayer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private int playerCount;
    private int roundCount;
    private final InputView inputView;
    private final OutputView outputView;
    private ArrayList<CarPlayer> carPlayers = new ArrayList<>();

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private void setVariables() {
        if(inputView.getPlayers() != null) {
            playerCount = inputView.getPlayers().size();
        }
        roundCount = inputView.getTrial();
    }

    private void moveCarPlayers() {

    }

    public void start() {
        inputView.inputGameInfo();
        setVariables();
        moveCarPlayers();
    }

}
