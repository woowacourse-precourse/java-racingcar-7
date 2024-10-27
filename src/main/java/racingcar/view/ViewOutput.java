package racingcar.view;

import java.util.List;
import racingcar.model.RacingCar;

public class ViewOutput {

    public static void printResult(List<RacingCar> cars){
        for(RacingCar car : cars){
            System.out.println(car.getName().trim() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
