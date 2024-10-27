package racingcar.value;

public class RacingCar {
    private final Player player;
    private final Distance distance;

    private RacingCar(Player player, Distance distance) {
        this.player = player;
        this.distance = distance;
    }

    public static RacingCar initAndFrom(Player player) {
        return new RacingCar(player, Distance.init());
    }

    public void moveForward(final MoveForward moveForward) {
        if (moveForward.isMovable()) {
            this.distance.increase();
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getPlayerNameString() {
        return this.player.name();
    }

    public Distance getDistance() {
        return this.distance;
    }
}