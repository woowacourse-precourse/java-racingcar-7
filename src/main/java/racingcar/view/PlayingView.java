package racingcar.view;

import racingcar.constant.ServiceMessage;
import racingcar.gameuserdata.RacingUserData;

public class PlayingView {
    public void RacingPlaying() {
        System.out.println();
        System.out.println(ServiceMessage.PLAYING_RACING.getMessage());
    }

    public void RacingUserPosition(RacingUserData racingUserData) {
        System.out.print(racingUserData.getRacingUserName() + ServiceMessage.PLAYING_RACING_COMMA.getMessage());
        String racingLength = "-".repeat(racingUserData.getForwardPosition());
        System.out.println(racingLength);
    }
}
