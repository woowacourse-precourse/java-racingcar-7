package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Vehicle;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import static racingcar.global.validator.InputValidator.*;

public class GameController {
    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;
    private static final int MINIMUM_FORWARD_THRESHOLD = 3;

    private final InputView inputView;
    private final OutputView outputView;

    private final List<Vehicle> carList = new ArrayList<>();
    private int round;
    private int max = 0;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play(){
        inputCarName();
        inputGameRound();
        startGame();
        outputWinner();
    }

    private void inputCarName(){
        outputView.printInputCarNameMessage();
        inputView.saveInput();
        validate(ValidationMode.CAR_NAME, inputView.getInput());
        validate(ValidationMode.CAR_COUNT, inputView.getInput());
        registerCar(inputView.getInput());
    }

    private void registerCar(String input){
        for(String name : input.split(",")) {
            this.carList.add(new Car(name));
        }
    }

    private void inputGameRound(){
        outputView.printInputGameRoundMessage();
        inputView.saveInput();
        validate(ValidationMode.GAME_COUNT, inputView.getInput());
        this.round = Integer.parseInt(inputView.getInput());
    }

    private void startGame(){
        while(round>0){
            runRounds();
            printGameRoundResult();
            round--;
        }
    }

    private void runRounds(){
        for(Vehicle car : carList){
            if(isMovingForward()){
               car.moveForward();
            }
            max = Math.max(car.getPosition(), max);
        }
    }

    private boolean isMovingForward(){
        return generateRandomNumber() > MINIMUM_FORWARD_THRESHOLD;
    }


    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    private void printGameRoundResult(){
        for(Vehicle car : carList){
            outputView.printGameRoundResult(car.getName(), car.showMovement());
        }
        outputView.printGameRoundSeparator();
    }

    private void outputWinner(){
        List<String> winners = new ArrayList<>();
        for(Vehicle car : carList){
            if(car.getPosition() == getMaxPosition())
                winners.add(car.getName());
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < winners.size()-1; i++){
            result.append(winners.get(i)).append(", ");
        }
        result.append(winners.getLast());
        outputView.printGameWinner(result.toString());
    }

    private int getMaxPosition(){
        return max;
    }
}
