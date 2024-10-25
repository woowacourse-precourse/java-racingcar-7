package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static void gameStart(){
        System.out.println("실행 결과");
    }

    public static void roundResult(Cars cars){
        cars.getCarList().forEach(car ->{
            System.out.print(car.getName() + ": " + car.getDistance());
        });
    }
}
