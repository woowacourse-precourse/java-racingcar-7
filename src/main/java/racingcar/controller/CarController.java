package racingcar.controller;

import racingcar.validation.RaceValidator;
import racingcar.view.InputView;
import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {

    public void startRace(){
        InputView inputView = new InputView();

        String carInput = inputView.inputCarNames();
        RaceValidator.validateCarName(carInput);
        carInput = removeSpaces(carInput);

        int tryInput = inputView.inputTryTo();
        RaceValidator.validateTryCount(String.valueOf(tryInput));

        List<Car> cars = Car.createCars(removeSpaces(carInput));
        randomMoves(cars, tryInput);

        OutputView.printRaceResult(Car.findWinner(cars));
    }


    private void randomMoves(List<Car> cars, int tryNumber){
        OutputView.printResult();
        for(int j=0;j<tryNumber;j++){
            for(int i=0;i<cars.size();i++){
                Car.randomMove(cars.get(i));
            }
            OutputView.printNow(cars);
        }
    }

    private String removeSpaces(String input){
        return input.replaceAll(" ","");
    }


}
