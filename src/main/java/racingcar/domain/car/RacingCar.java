package racingcar.domain.car;

public class RacingCar {
    private String name;
    private int distance = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public void move(){
        distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance(){
        return distance;
    }
}
