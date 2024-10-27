package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RacingcarServiceImpl implements RacingcarService {
    private static final RacingcarServiceImpl instance = new RacingcarServiceImpl();

    private RacingcarServiceImpl() {}

    public static RacingcarServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void startRaceByCount(List<Racingcar> racingcars) {
        for (Racingcar racingcar: racingcars) {
            if (checkRandomValue()) {
                racingcar.move();
            }
        }
    }

    @Override
    public List<Racingcar> determineWinner(List<Racingcar> racingcars) {
        List<Racingcar> winners = new ArrayList<>();

        int maxDistance = getMaxDistance(racingcars);

        for (Racingcar racingcar: racingcars) {
            if (racingcar.getDistance() == maxDistance) {
                winners.add(racingcar);
            }
        }

        return winners;
    }

    private boolean checkRandomValue() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private int getMaxDistance(List<Racingcar> racingcars) {
        List<Integer> distances = new ArrayList<>();
        for (Racingcar racingcar : racingcars) {
            distances.add(racingcar.getDistance());
        }

        Optional<Integer> maxDistance = distances.stream().max(Integer::compareTo);
        return maxDistance.orElse(0);
    }
}
