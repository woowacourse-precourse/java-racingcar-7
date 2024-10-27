package racingcar.DTO;

import java.util.HashMap;

public class RaceResultDTO {
    HashMap<String, Integer> carList = new HashMap<>();

    public RaceResultDTO(HashMap<String, Integer> carList) {
        this.carList = carList;
    }

    public HashMap<String, Integer> getCarList() {
        return carList;
    }
}
