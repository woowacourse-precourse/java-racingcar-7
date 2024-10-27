package racingcar.Dto;

import java.util.List;

public class RoundResult {
    private final List<CarData> carData;

    public RoundResult(List<CarData> carData) {
        this.carData = carData;
    }
    public List<CarData> getCarData(){
        return carData;
    }
}
