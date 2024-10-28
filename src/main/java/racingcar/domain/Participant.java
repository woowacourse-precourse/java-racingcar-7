package racingcar.domain;

class Participant {

    private final Car car;
    private int score;

    Participant(final Car car, final int score) {
        this.car = car;
        this.score = score;
    }

    ProgressedInformation getInfo() {
        return new ProgressedInformation(car, score);
    }

    void move(final MoveCondition moveCondition) {
        if (car.canMove(moveCondition)) {
            score++;
        }
    }

    int getScore() {
        return this.score;
    }

    public Car getCar() {
        return this.car;
    }
}
