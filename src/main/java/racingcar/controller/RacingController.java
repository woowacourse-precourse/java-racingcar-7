package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.inputview.InputHandler;
import racingcar.model.Car;
import racingcar.outputview.OutputHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {
    InputHandler inputHandler;
    OutputHandler outputHandler;
    public RacingController(){
        this.inputHandler = new InputHandler();
        this.outputHandler = new OutputHandler();
    }

    public void run(){
        outputHandler.promptCarNameInput();
        String[] carNames = inputHandler.split(Console.readLine());
        outputHandler.promptAttemptCountInput();
        int attemptGameCount = inputHandler.getAttemptGameCount();

        List<Car> carList = new ArrayList<>();
        for(String car: carNames){
            carList.add(new Car(car));
        }

        List<Car> result = gameStart(carList, attemptGameCount);

        outputHandler.showWinners(getWinner(result));




    }

    private List<Car> gameStart(List<Car> carList , int gameCount){
        int currentCount = 0;
        outputHandler.showGameResult();
        while(currentCount < gameCount){
            for(Car car : carList){
                if(Randoms.pickNumberInRange(0,9) >= 4){
                    car.moveFoward();
                }
            }
            outputHandler.showCurrentCarPosition(carList);
            currentCount++;
        }
        return carList;
    }

    private List<Car> getWinner(List<Car> carList){

        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

    }


}
