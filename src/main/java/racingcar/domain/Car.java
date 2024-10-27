package racingcar.domain;

public class Car implements Comparable<Car>{
    private Score score;
    private UserName userName;

    public Car(String userName) {
        this.score = new Score();
        this.userName = new UserName(userName);
    }

    public int getScore() {
        return score.getScore();
    }

    public String getUserName() {
        return userName.getUserName();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.score.getScore(), o.score.getScore());
    }
}
