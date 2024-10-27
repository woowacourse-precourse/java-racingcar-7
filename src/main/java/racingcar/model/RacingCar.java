package racingcar.model;


public class RacingCar {
    private String name;
    private int distance;

    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goAhead(int num) {
        if (num>=4){
            distance+=1;
        }
    }

}
