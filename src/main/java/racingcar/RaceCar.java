package racingcar;

public class RaceCar {
    private String name;
    private int forward;

    public RaceCar(String name){
        this.name = name.trim();
        this.forward = 0;
    }

    public String getName() {
        return name;
    }

    public int getForward(){
        return forward;
    }

    public void updateForward(int forward){
        this.forward += forward;
    }
}
