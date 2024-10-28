package racingcar;

public class RaceCar {
    private String name;
    private int forward;

    public RaceCar(String name){
        this.name = name;
        this.forward = 0;
    }

    public String getName() {
        return name;
    }

    public int getForward(){
        return forward;
    }
}
