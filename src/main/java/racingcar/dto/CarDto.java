package racingcar.dto;

public class CarDto {
    public static class CarOutputDto {
        private final String carName;

        public CarOutputDto(String carName) {
            this.carName = carName;
        }

        public String getCarName() {
            return carName;
        }
    }

}
