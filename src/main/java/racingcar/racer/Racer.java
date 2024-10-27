package racingcar.racer;

public abstract class Racer {
    private final String name;
    private String distance = ""    ;

    public Racer(String name) {
        this.name = name;
    }

    public void tryMove() {
        if(move()){
            distance += "-";
        }
    }

    public abstract boolean move();

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
