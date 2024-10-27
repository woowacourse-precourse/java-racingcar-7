package inspector;

import java.util.ArrayList;
import racingcar.OutputManager;
import racingcar.RacingCar;

public class InspectRaceResult {
    ArrayList<String> winner = new ArrayList<>();
    private int highDistance = 0;

    public void inspecting(ArrayList<RacingCar> group){
        for(RacingCar racingCar : group){
            elementInspecting(racingCar);
        }
        OutputManager.printRaceResult(winner);
    }

    public void elementInspecting(RacingCar racingCar){
        if(racingCar.compareTo(highDistance) == 0){
            winner.add(racingCar.getCarName());
        }
        if(racingCar.compareTo(highDistance) == 1){
            winner.clear();
            winner.add(racingCar.getCarName());
            highDistance = racingCar.getDistance();
        }
    }
}
