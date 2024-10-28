package racingcar;

public class RacingRoundResultOutput implements GameRoundResultOutput {
    private final String name;
    private final int position;

    public RacingRoundResultOutput(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getGameRoundOutputFormat() {
        return name + " : " + "-".repeat(position);
    }
}
