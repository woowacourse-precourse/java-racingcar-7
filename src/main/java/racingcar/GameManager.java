package racingcar;

import constant.Constants;
import inspector.InspectResult;
import utils.ContentParser;

public class GameManager {
    private String[] playerGroup;
    private RacingCar[] racingCarGroup;
    private int playerTurn;
    private int currentTurn = 0;

    public void execute() {
        playerSetting();
        raceSetting();
    }

    private void playerSetting(){
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

    private void raceSetting(){
        OutputManager.printBlankLine();
        System.out.println(Constants.RACING_START_MESSAGE);
        while(currentTurn < playerTurn){
            groupMoving();
            OutputManager.printCurrentResult(racingCarGroup);
            currentTurn++;
        }
        InspectResult inspectResult = new InspectResult();
        inspectResult.inspecting(racingCarGroup);
    }

    private void groupMoving(){
        for(int i = 0; i < racingCarGroup.length; i++){
            racingCarGroup[i].addDistance();
        }
    }
}
