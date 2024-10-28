package racingcar.domain;

public class RacingCar {
    private String nameOfCar;
    private int positionOfCar;

    public RacingCar(String nameOfCar){
        this.nameOfCar = nameOfCar;
        this.positionOfCar = 1;
    }

    public void moveCarPosition(){
        positionOfCar += 1;
    }

    public int getCarPosition(){
        return positionOfCar;
    }

    public String getCarName(){
        return nameOfCar;
    }
}