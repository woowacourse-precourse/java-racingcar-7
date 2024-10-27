package racingcar.model;

public class RacingCar implements Car{
    private int score;
    private String name;


    @Override
    public void addScore() {
        score++;
    }

    public RacingCar(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}
