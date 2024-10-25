package racingcar.model;

public class Cars {
    private String carName;
    private int distance;

    public Cars(String carName){
        this.carName = carName;
        this.distance = 0;
    }

    public String getCarName(){
        return this.carName;
    }
    public int getDistance(){
        return this.distance;
    }

    public void setDistance(int distance){
        this.distance += distance;
    }
}
