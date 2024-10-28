package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Racingcar;
import racingcar.dto.RacingcarResults;

import java.util.ArrayList;
import java.util.List;

public class SimpleRacingcarService implements RacingcarService {

    private List<Racingcar> racingcars;

    public SimpleRacingcarService() {
        this.racingcars = new ArrayList<>();
    }

    @Override
    public void setRacingcars(List<String> carNames) {
        carNames.forEach(i -> racingcars.add(new Racingcar(i)));
    }

    @Override
    public RacingcarResults racing() {
        racingcars.stream()
                .filter(racingcar -> isForward())
                .forEach(Racingcar::moveForward);

        return this.getRacingResult();
    }

    private boolean isForward() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum >= 4;
    }

    public RacingcarResults getRacingResult() {
        RacingcarResults results = new RacingcarResults();
        racingcars.forEach(racingcar -> results.addResults(racingcar.getName(), racingcar.getPosition()));
        return results;
    }

    @Override
    public List<String> findWinner() {
        int max = racingcars.stream()
                .mapToInt(Racingcar::getPosition)
                .max()
                .orElseThrow(RuntimeException::new);

        return racingcars.stream()
                .filter(racingcar -> racingcar.getPosition() == max)
                .map(Racingcar::getName)
                .toList();
    }
}
