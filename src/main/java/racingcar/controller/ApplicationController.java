package racingcar.controller;

import racingcar.domain.random.DefaultRandomGenerator;
import racingcar.domain.random.FixedRandomGenerator;
import racingcar.utility.Utils;
import racingcar.view.ProgressAndResultOutput;
import racingcar.view.UserInput;

import java.util.Arrays;
import java.util.List;

public class ApplicationController {
    private final int tryNum;
    private final String carsName;
    private final UserInput userInput;
    private final CarRaceController carRaceController;
    private final ProgressAndResultOutput progressAndResultOutput;

    public ApplicationController(){
        userInput = new UserInput();
        carsName = userInput.promptCarNameUserInput();
        Utils.checkEmptyInput(carsName);
        String inputMessage = userInput.promptTryNumUserInput();
        Utils.checkEmptyInput(inputMessage);
        tryNum = Utils.checkTryNumberInteger(inputMessage);
        Utils.checkTryNumberRange(tryNum);

        carRaceController = new CarRaceController(splitCarsName(carsName), new DefaultRandomGenerator());

        progressAndResultOutput = new ProgressAndResultOutput();

        startRace();
    }
    public ApplicationController(List<Integer> fixRandomValue){ // 테스트용
        userInput = new UserInput();
        carsName = userInput.promptCarNameUserInput();
        Utils.checkEmptyInput(carsName);
        String inputMessage = userInput.promptTryNumUserInput();
        Utils.checkEmptyInput(inputMessage);
        tryNum = Utils.checkTryNumberInteger(inputMessage);
        Utils.checkTryNumberRange(tryNum);

        carRaceController = new CarRaceController(splitCarsName(carsName), new FixedRandomGenerator(fixRandomValue));

        progressAndResultOutput = new ProgressAndResultOutput();

        startRace();
    }

    private List<String> splitCarsName(String carsName){
        return Arrays.asList(carsName.split(","));
    }
    private void displayRoundRace(){
        progressAndResultOutput.displayRoundProgress(carRaceController.getPlayCarsName(), carRaceController.getPlayCarsStep());
    }
    private void displayRaceResult(){
        progressAndResultOutput.winnerOutput(carRaceController.getRaceWinners());
    }
    private void startRace(){
        progressAndResultOutput.startProgressOutput();
        for(int i = 0; i < tryNum; i++){
            carRaceController.playRaceOnce();
            displayRoundRace();
        }
        displayRaceResult();
    }
}
