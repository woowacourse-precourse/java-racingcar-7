package racingcar;

import utils.ContentParser;

public class RaceManager {
    private String[] playerGroup;
    private RacingCar[] racingCarGroup;
    private int playerTurn;

    public void execute() {
        playerGroup = playerGroupSetting();
        playerTurn = playerTurnSetting();
        racingCarGroup = RacingCarFactory.createRacingCarGroup(playerGroup);
    }

    private String[] playerGroupSetting(){
        String inputContent = InputManager.inputPlayerNameGroup();
        return ContentParser.parsingContentToGroup(inputContent);
    }

    private int playerTurnSetting(){
        return InputManager.inputPlayerTurn();
    }
}
