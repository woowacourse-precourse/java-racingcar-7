package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;


public class Race {
    private List<Car> raceParticipants;
    private int rounds;

    public Race(List<Car> raceParticipants, int rounds) {
        this.raceParticipants = raceParticipants;
        this.rounds = rounds;
    }

    public void start() {

        for (int i = 0; i < rounds; i++) {
            moveCars();
            OutputView.printRoundResult(raceParticipants);
        }
    }

    private void moveCars() {
        for (Car car : raceParticipants) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<Car> getWinner() {
        int maxPosition = raceParticipants.stream()
                .mapToInt(car -> car.getPosition().length())
                .max()
                .orElse(0);

        return raceParticipants.stream()
                .filter(car -> car.getPosition().length() == maxPosition)
                .collect(Collectors.toList());
    }


}
