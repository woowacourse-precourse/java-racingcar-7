package racingcar.record;

import java.util.HashMap;
import java.util.Map;
import racingcar.racingcar.RacingCar;

public class Record {
    private Map<RacingCar,Integer> latest;
    public Record(){
        latest = new HashMap<>();
    }

}
