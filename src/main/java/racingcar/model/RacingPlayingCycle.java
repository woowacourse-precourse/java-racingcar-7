package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.gameuserdata.RacingUserData;
import racingcar.view.PlayingView;

public class RacingPlayingCycle {
    private final PlayingView playingView;

    public RacingPlayingCycle() {
        playingView = new PlayingView();
    }

    public List<RacingUserData> racingPlayingCycle(int racingCount, List<RacingUserData> racingUserDataList) {
        playingView.RacingPlaying();

        for (int i = 0; i < racingCount; i++) {
            raceUsers(racingUserDataList);
        }

        return racingUserDataList;
    }

    private void raceUsers(List<RacingUserData> racingUserDataList) {
        for (RacingUserData racingUserData : racingUserDataList) {
            int r = Randoms.pickNumberInRange(0, 9);
            if (r >= 4) {
                racingUserData.addOneMoveForwardPosition();
            }
            playingView.RacingUserPosition(racingUserData);
        }
    }
}
