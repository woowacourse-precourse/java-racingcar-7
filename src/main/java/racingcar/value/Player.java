package racingcar.value;

public record Player(
    String name
) {

    public static Player from(final String player) {
        return new Player(player);
    }
}