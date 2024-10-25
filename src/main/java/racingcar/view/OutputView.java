package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void roundStart(){
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void roundOutput(List<Car> cars) {
        for(Car car : cars) {
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getDistance(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
