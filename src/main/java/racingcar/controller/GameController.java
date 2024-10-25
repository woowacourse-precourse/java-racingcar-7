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
    private final InputView inputView;
    private final OutputView outputView;

    private final List<Vehicle> carList = new ArrayList<>();
    private int round;
    private int max = 0;

    public GameController(){
        inputView = new InputView();
        outputView = new OutputView();
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
        return generateRandomNumber() > 3;
    }


    private int generateRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }

    private void printGameRoundResult(){
        for(Vehicle car : carList){
            outputView.printGameRoundResult(car.getName(), car.showMovement());
        }
        System.out.println();
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
