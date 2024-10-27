package racingcar.domain;

public class Car implements Comparable<Car>{
    private final int MOVE_CONDITION_LIMIT = 4;

    private Score score;
    private UserName userName;

    public Car(String userName) {
        this.score = new Score();
        this.userName = new UserName(userName);
    }

    public Score getScore() {
        return score;
    }

    public void moveCar(int randomNumber) {
        if(randomNumber >= MOVE_CONDITION_LIMIT) {
            this.score.moveForward();
        }
    }

    public String getUserName() {
        return userName.getUserName();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.score.getScore(), o.score.getScore());
    }
}
