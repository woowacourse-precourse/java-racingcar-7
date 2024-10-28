package racingcar;

import constant.Constants;
import inspector.InspectRaceResult;
import java.util.ArrayList;
import utils.ContentParser;

public class GameManager {
    private ArrayList<RacingCar> racingCarGroup;
    private int racingTurn;
    private int currentTurn = 0;

    public void execute() {
        playerSetting();
        raceSetting();
    }

    private void playerSetting(){
        ArrayList<String> playerGroup = playerGroupSetting();
        racingTurn = playerTurnSetting();
        racingCarGroup = RacingCarFactory.generateRacingCarGroup(playerGroup);
    }

    private ArrayList<String> playerGroupSetting(){
        String inputContent = InputManager.inputPlayerGroup();
        return ContentParser.parsingContentToGroup(inputContent);
    }

    private int playerTurnSetting(){
        return InputManager.inputRacingTurn();
    }

    private void raceSetting(){
        OutputManager.printBlankLine();
        System.out.println(Constants.RACING_START_MESSAGE);

        while(currentTurn < racingTurn){
            racingCurrentTurn();
            OutputManager.printCurrentResult(racingCarGroup);
            currentTurn++;
        }

        InspectRaceResult inspectRaceResult = new InspectRaceResult();
        inspectRaceResult.inspectWinner(racingCarGroup);
    }

    private void racingCurrentTurn(){

        for(RacingCar racingCar : racingCarGroup){
            racingCar.addDistance();
        }

    }
}
