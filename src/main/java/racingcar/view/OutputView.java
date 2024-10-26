package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public void printTrialResult(Cars cars){
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            System.out.println(car.getName()+" : "+car.getPosition());
            System.out.println();
        }
    }

    public void printWinningCars(Cars winningCars){
        List<Car> winningCarGroup = winningCars.getCarGroup();
        //String
        //System.out.println("최종 우승자 : ",);
    }
}
