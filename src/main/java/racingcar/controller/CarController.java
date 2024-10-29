package racingcar.controller;

import racingcar.validation.RaceValidator;
import racingcar.view.InputView;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {

    public void startRace(){
        InputView inputView = new InputView();

        String carsInput = inputView.inputParticipantNames();
        RaceValidator.validateCarName(carsInput);
        carsInput = removeSpaces(carsInput);

        int attemptsInput = inputView.inputAttempts();
        RaceValidator.validateTryCount(String.valueOf(attemptsInput));

        List<Car> cars = Car.createCars(removeSpaces(carsInput));
        simulateCarMovements(cars, attemptsInput);

        OutputView.printFinalWinners(Car.findWinningCars(cars));
    }


    private void simulateCarMovements(List<Car> cars, int attempts){
        OutputView.printResult();
        for(int j=0;j<attempts;j++){
            for(int i=0;i<cars.size();i++){
                Car.tryRandomMove(cars.get(i));
            }
            OutputView.printCurrentPositions(cars);
        }
    }

    private String removeSpaces(String input){
        return input.replaceAll(" ","");
    }


}
