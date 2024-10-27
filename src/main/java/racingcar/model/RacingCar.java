package racingcar.model;

public class RacingCar {
    private static final int MOVE_STANDARD = 4;

    private String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int randomNumber){
        if(randomNumber > MOVE_STANDARD){
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
