package racingcar;

public class RacingCar {
    public final String carName;
    public int numberOfForward = 0;
    public RacingCar(String carName){
        if(carName == null || carName.length() > 5 || carName.trim().isEmpty()) throw new IllegalArgumentException();
        this.carName = carName;
    }

}
