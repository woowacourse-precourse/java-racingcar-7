package racingcar.car.service.dto;

public class CarCreateReqDto {
    private String carName;

    public CarCreateReqDto(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
