package racingcar.Model;

import racingcar.Controller.ForwardController;

import java.util.ArrayList;
import java.util.List;

public class WinGenerator {
    public static List<String> findWinners(List<ForwardController> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;

        for (ForwardController car : cars) {
            if(car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for(ForwardController car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
