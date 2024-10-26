package racingcar;

public class RacingCar {
    public final String carName;
    public int length = 0;
    public RacingCar(String carName){
        if(carName == null || carName.length() > 5) throw new IllegalArgumentException();
        this.carName = carName;
    }


}
