package racingcar.domain.dto;

public class CarDto {

    private final String carName;
    private final int position;

    public CarDto(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
