package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.CarPlayer;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private int playerNum;
    private int roundCount;
    private InputView inputView;
    private OutputView outputView;
    private ArrayList<CarPlayer> carPlayers;


    public RacingGameController() {
        inputView = new InputView();
        outputView = new OutputView();

        if(inputView.getPlayers()!=null) {
            playerNum = inputView.getPlayers().size();
        }

        roundCount = inputView.getTrial();

        for(int i=0; i<playerNum; i++) {
            carPlayers.add(new CarPlayer());
        }
    }

    public void start() {
        inputView.inputGameInfo();
    }
}
