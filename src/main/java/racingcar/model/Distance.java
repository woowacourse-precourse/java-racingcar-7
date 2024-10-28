package racingcar.model;

public class Distance {
    private int distance;

    public Distance() {
        this.distance = 0;
    }
    public int getDistanceValue() {
        return distance;
    }

    public void goForInt(int randomValue) {
        if(isAbleToGo(randomValue)) {
            distance += randomValue;
        }

    }

    public boolean isAbleToGo(int randomValue) {
        return randomValue >= 4;
    }
}
