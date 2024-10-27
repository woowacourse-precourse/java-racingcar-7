package racingcar.model;

public class RacingCar {
    private static final int MOVE_STANDARD = 4;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int randomNumber){
        if(randomNumber >= MOVE_STANDARD){
            position++;
        }
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }
}
