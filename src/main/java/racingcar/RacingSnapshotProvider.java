package racingcar;

public class RacingSnapshotProvider {

    public static final String PATH_SIGN = "-";

    public String getSnapshotOf(Player player) {
        int distance = player.getDistance();

        String path = "";
        for (int i = 0; i < distance; i++) {
            path = path.concat(PATH_SIGN);
        }

        return player.getName() + " : " + path;
    }
}
