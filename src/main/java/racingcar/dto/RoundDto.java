package racingcar.dto;

import java.util.List;

public class RoundDto {
    private final List<CarDto> carDtos;
    private final Integer round;

    public RoundDto(List<CarDto> carDtos, Integer round) {
        this.carDtos = carDtos;
        this.round = round;
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    public Integer getRound() {
        return round;
    }
}
