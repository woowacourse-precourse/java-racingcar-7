package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarsService;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import random.RandomGenerate;

import java.util.List;

public class CarsController {

    private InputView inputView;
    private OutputView outputView;
    private RandomGenerate randomGenerate;
    private final int startIndex = 0;
    private CarsService carsService;

    public CarsController(InputView inputView, OutputView outputView, RandomGenerate randomGenerate, CarsService carsService){
        this.inputView = inputView;
        this.outputView = outputView;
        this.randomGenerate = randomGenerate;
        this.carsService = carsService;
    }

    public void startCarsMove(){
        List<String> carNames = inputView.inputName();
        Cars cars = new Cars(carNames, randomGenerate);
        this.carsService = new CarsService(cars);
        int numberOfMove = inputView.integerInput();
        outputView.printDefault();
        
        for(int i = startIndex; i < numberOfMove; i++){
            cars.carsMove();
            outputView.printCarsMove(carsService.carsDetail());
        }

        List<String> winner = carsService.winnerList();
        outputView.printWinner(winner);
    }

}
