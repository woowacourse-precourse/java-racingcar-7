package racingcar.controller;

import java.lang.reflect.Array;
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
    private ArrayList<String> gameResult;


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

    private void innerGameLogic() {
        for(int i=0; i<roundCount; i++) {
            for(int j=0; j<playerNum; j++) {
                carPlayers.get(i).move();
            }
        }
        for(int k=0; k<playerNum; k++) {
            gameResult.add(carPlayers.get(k).getSteps());
        }
    }

    public ArrayList<String> getGameResult() {
        return gameResult;
    }

    public void start() {
        inputView.inputGameInfo();
        innerGameLogic();
    }

}
