package racingcar.dto;

import java.util.List;

public class RoundResult {
    private List<CarDto> carDtoList;

    public RoundResult(List<CarDto> carDtoList) {
        this.carDtoList = carDtoList;
    }

    public List<CarDto> getCarDtoList() {
        return carDtoList;
    }
}
