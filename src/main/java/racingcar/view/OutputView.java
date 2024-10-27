package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void resultText(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public void resultPerOneCircle(List<Car> carList){
        for (Car car : carList){
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

}
