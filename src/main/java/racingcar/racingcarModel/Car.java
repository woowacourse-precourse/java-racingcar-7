package racingcar.racingcarModel;


public class Car {

    private String carName;
    private int carMove;


    public Car() {
    }


    public Car(String carName) {
        this.carName = carName;
        this.carMove = 0;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarMove() {
        return carMove;
    }

    public void setCarMove(int carMove) {
        this.carMove = carMove;
    }
}


