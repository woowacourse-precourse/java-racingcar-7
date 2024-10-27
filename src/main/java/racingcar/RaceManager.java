package racingcar;

import java.util.List;

public class RaceManager {
    private RaceMember raceMember;

    public void raceStart(List<String> carList, int round) {
        raceMember = new RaceMember(carList);
        race(round);
    }

    private void race(int round) {
        for (int i = 0; i < round; i++) {
            raceMember.moveAll();
            OutputView.reportProgress(raceMember.getRaceMember());
        }
        OutputView.reportRaceResult(raceMember.getWinner());
    }
}
