package racingcar;

import utils.PlayerMoving;

public class RacingCar {
    private String carName;
    private int distance = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    protected void addDistance(){
        if(PlayerMoving.isMoveAble()){
            distance++;
        }
    }

    public String getCarName(){
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    //toString 메서드 오버라이딩으로 system.out.print로 출력이 바로 가능하게끔 설정
    @Override
    public String toString(){
        return carName + " : " + "-".repeat(distance);
    }

    public boolean isNewWinner(int previousHighestDistance){
        return distance>previousHighestDistance;
    }

    public boolean isSameDistance(int highestDistance){
        return distance == highestDistance;
    }
}
