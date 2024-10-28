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

    public static void winnerOutput(List<Car> cars) {
        String winnerName = cars.get(0).getName();
        System.out.print("최종 우승자 : " + winnerName);

        int distance = cars.get(0).getDistance();
        for(int i = 1; i < cars.size(); i++){
            if(cars.get(i).getDistance() != distance) {
                break;
            }
            System.out.print(", " + cars.get(i).getName());
        }
    }
}
