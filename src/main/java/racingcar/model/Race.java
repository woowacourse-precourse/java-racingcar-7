package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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
                car.move(randomValue);

            }
            OutputView.printRoundResult(raceParticipants);

        }
    }

    public List<Car> getWinner() {
        int maxLength = 0;
        for (Car car : raceParticipants) {
            int positionLength = car.getPosition().length();
            if (positionLength > maxLength) {
                maxLength = positionLength;
            }
        }

        List<Car> result = new ArrayList<>();
        for (Car car : raceParticipants) {
            if (car.getPosition().length() == maxLength) {
                result.add(car);
            }
        }
        return result;
    }


}
