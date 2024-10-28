package race;

import car.Car;
import java.util.List;

public class RacingProgress {
    private final List<Car> carList;
    private Integer roundCount;

    public RacingProgress(List<Car> carList, Integer roundCounter){
        this.carList = carList;
        this.roundCount = roundCounter;
    }
}
