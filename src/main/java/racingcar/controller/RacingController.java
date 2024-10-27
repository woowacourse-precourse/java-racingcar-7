package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private static int maxDistance = 0;
    private static int winnerCount = 0;
    public RacingController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void startRacing(){
        outputView.printGameStart();
        List<String> carNames = inputView.inputNames();
        Cars cars = new Cars(carNames);
        int tryCount = inputTryCount();
        racingGame(tryCount, cars);
    }
    private int inputTryCount(){
        outputView.printTryInput();
        String tryCountValue = inputView.inputTryCount();
        TryCount tryCount = new TryCount(tryCountValue);
        return tryCount.getTryCount();
    }
    private void racingGame(int tryCount, Cars cars){
        outputView.printResult();
        Racing racing = new Racing();
        for(int i=0 ; i<tryCount ; i++){
            racing.startRace(cars);
            outputView.printExecuteResult(cars);
        }
        gameResult(cars);
    }
    private void gameResult(Cars cars){
        List<Car> carList = cars.getCars();
        for(Car car:carList){
            getMaxDistance(car);
        }
        outputView.printWinner(cars, maxDistance, winnerCount);
    }
    private void getMaxDistance(Car car){
        if (maxDistance == car.getDistance()){
            winnerCount += 1;
        }
        if (maxDistance < car.getDistance()){
            maxDistance = car.getDistance();
            winnerCount = 0;
        }
    }
}
