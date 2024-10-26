package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static String SPLIT_SIGN = ",";
    public void outputTrialResult(Cars cars){
        List<Car> carGroup = cars.getCarGroup();
        for (Car car : carGroup) {
            System.out.println(car.getName()+" : "+car.getPosition());
            System.out.println();
        }
    }

    public void outputWinningCars(List<Car> winningCarGroup){
        String printWinningGroup = new String();
        for (Car car : winningCarGroup) {
            printWinningGroup.concat(car.getName()+SPLIT_SIGN+" ");
        }
        System.out.println("최종 우승자 : "+ printWinningGroup);
    }
}
