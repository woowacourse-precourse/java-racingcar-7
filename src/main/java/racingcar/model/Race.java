package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;


public class Race {
    private List<Car> raceParticipants;
    private int rounds;

    public Race(List<Car> raceParticipants, int rounds) {
        this.raceParticipants = raceParticipants;
        this.rounds = rounds;
    }

    public void start() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i <= rounds; i++) {
            for (Car car : raceParticipants) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                //car.move(randomValue); 미구현

            }
            OutputView.printRoundResult(raceParticipants);

        }
    }


}
