package racingcar;

public class RacingCar {
    public final String carName;
    public int numberOfForward = 0;
    public RacingCar(String carName){
        if(carName == null || carName.length() > 5 || carName.trim().isEmpty()) throw new IllegalArgumentException(); //null, 5초과 길이, 빈 문자열
        this.carName = carName;
    }

}
