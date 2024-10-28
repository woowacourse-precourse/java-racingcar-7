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
    @Override
    public int getScore() {
        return score;
    }
    @Override
    public String getName() {
        return name;
    }
}
