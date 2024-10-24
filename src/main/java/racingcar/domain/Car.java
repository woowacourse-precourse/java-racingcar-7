package racingcar.domain;

public class Car { // 자동차를 관리하는 클래스
    private String carName;
    private int position = 0;
    private String positionString = "";

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void positionToString(int position){
        positionString = "";
        for(int i=0; i<position; i++){
            positionString += "-";
        }
    }

    @Override
    public String toString() {
        positionToString(position);
        return carName + " : " + positionString;
    }
}
