package racingcar.view.output;

public class RacingRoundView implements RoundView {
    private final String name;
    private final int position;

    public RacingRoundView(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public String getGameRoundOutputFormat() {
        return name + " : " + "-".repeat(position);
    }
}
