package racingcar.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {
    List<RacingCar> racingCarList;

    public Race(List<String> racingCarsName){
        this.racingCarList = racingCarsName.stream()
                .map(RacingCar::new).toList();
    }
    public HashMap<String, Integer> retrieveRaceResults(){
        executeRace();
        HashMap<String, Integer> executedResult = new HashMap<>();
        racingCarList.forEach(racingCar ->
                executedResult.put(racingCar.getName(), racingCar.getMoveCount()));
        return executedResult;
    }

    private void executeRace() {
        racingCarList.forEach(RacingCar::move);
    }

}
