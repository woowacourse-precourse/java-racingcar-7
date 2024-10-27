package racingcar.model;

public class Race {
    private RaceTurn turn;

    public Race(int turn) {
        this.turn = new RaceTurn(turn);
    }
}
