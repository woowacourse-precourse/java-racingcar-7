package racingcar.service;

import racingcar.model.Car;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class CarService {

    private final Car car;
    private final OutputView outputView;

    public CarService(){
        this.car = new Car();
        this.outputView = new OutputView();
    }

    public Map<String, Integer> carNames(String inputCarName) {
        return car.carNameSplit(inputCarName);
    }

    public Map<String, Integer> racing(Map<String, Integer> cars, int count){

        System.out.println("실행 결과");

        for(int i=0; i<count; i++){
            cars = car.racingTry(cars);
            outputView.racingView(cars);
        }

        return cars;
    }

    public void result(Map<String, Integer> cars){
        List<String> winnerCarList = car.getWinningCars(cars);
    }
}
