package inspector;

import java.util.ArrayList;
import racingcar.OutputManager;
import racingcar.RacingCar;

public class InspectResult {
    ArrayList<String> winner = new ArrayList<>();
    int highDistance = 0;

    public void inspecting(RacingCar[] group){
        for(int i = 0; i < group.length; i++){
            elementInspecting(group[i]);
        }
        OutputManager.printResult(winner);
    }

    public void elementInspecting(RacingCar car){
        if(car.compareTo(highDistance) == 0){
            winner.add(car.getCarName());
        }
        if(car.compareTo(highDistance) == 1){
            winner.clear();
            winner.add(car.getCarName());
            highDistance = car.getDistance();
        }
    }
}
