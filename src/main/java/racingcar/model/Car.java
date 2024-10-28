package racingcar.model;

public class Car {
    private String name;
    private int score;

    public Car(String name) {

        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move(int moveStateValue) {
        if ((moveStateValue >= 4) && (moveStateValue <= 9)) {
            this.score++;
        }
    }

}
