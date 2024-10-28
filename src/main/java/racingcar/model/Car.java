package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Distance distance;
    private final int order;

    public Car(String name, int order){
        this.name = name;
        this.order = order;
        this.distance = new Distance();
    }

    public String getName() {
        return name;
    }

    public Distance getDistance(){
        return distance;
    }

    public String getDistanceStatusBar(int distance){
        return "-".repeat(Math.max(0, distance));
    }

    public int getRandomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveIfTrue(int randomValue) {
        if(distance.isAbleToGo(randomValue)) {
          distance.goForInt(randomValue);
        }

    }

}
