package racingcar;

public class RacingCarService {
    private final RacingCars racingCars;
    public RacingCarService(String readLine) {
        racingCars = new RacingCars(readLine);
    }
}
