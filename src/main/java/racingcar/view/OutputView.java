package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static String SPLIT_SIGN = ",";

    private String createCarPositionLine(int carPosition){
        String carPositionLine = new String();
        for(int i=0;i<carPosition;i++){
            carPositionLine = carPositionLine.concat("-");
        }
        return carPositionLine;
    }

    public void outputTrialResult(Cars cars) {
        List<Car> carGroup = cars.getCarGroup();
        System.out.println("실행 결과");
        for (Car car : carGroup) {
            String carPositionLine = createCarPositionLine(car.getPosition());
            System.out.println(car.getName() + " : " + carPositionLine);
        }
        System.out.println();
    }

    public void outputWinningCars(List<Car> winningCarGroup) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : winningCarGroup) {
            winningCarNames.add(car.getName());
        }
        String printWinningGroup = String.join(SPLIT_SIGN+" ", winningCarNames);
        System.out.println("최종 우승자 : " + printWinningGroup);
    }
}
