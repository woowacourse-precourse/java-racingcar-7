package racingcar.model;

public class Turn {
    private int turn;

    public Turn(String input) {
        setTurn(input);
    }

    public void setTurn(String input) {
        try {
            this.turn = Integer.parseInt(input);
            if (turn < 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int getTurn() {
        return turn;
    }
}