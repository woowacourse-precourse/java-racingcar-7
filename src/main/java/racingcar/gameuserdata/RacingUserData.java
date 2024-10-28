package racingcar.gameuserdata;

public class RacingUserData {
    private final String racingUserName;
    private int forwardPosition;

    private RacingUserData(String racingUserName, int forwardPosition) {
        this.racingUserName = racingUserName;
        this.forwardPosition = forwardPosition;
    }

    public static RacingUserData of(String racingUserName) {
        return new RacingUserData(racingUserName, 0);
    }

    public String getRacingUserName() {
        return racingUserName;
    }

    public int getForwardPosition() {
        return forwardPosition;
    }

    public void addOneMoveForwardPosition() {
        this.forwardPosition = forwardPosition + 1;
    }
}
