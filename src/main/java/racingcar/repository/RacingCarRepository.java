package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import racingcar.domain.Vehicle;

public class RacingCarRepository implements Repository{
    private final Map<String, Vehicle> racingCarRepository;

    public RacingCarRepository(Map<String, Vehicle> racingStatusRepository) {
        this.racingCarRepository = racingStatusRepository;
    }

    public void save(String name, Vehicle car) {
        racingCarRepository.put(name, car);
    }


    public Vehicle find(String name) {
        return racingCarRepository.get(name);
    }


    public int size() {
        return racingCarRepository.size();
    }

    public List<String> findWinner() {
        ArrayList<String> keySet = new ArrayList<>(racingCarRepository.keySet());
        List<String> winnerList = new ArrayList<>();

        keySet.sort((o1, o2) -> racingCarRepository.get(o2).getMoveForwardCount().compareTo(racingCarRepository.get(o1).getMoveForwardCount()));
        for (String key : keySet) {
            if (!winnerList.isEmpty() && racingCarRepository.get(winnerList.get(0)).getMoveForwardCount()
                    .equals(racingCarRepository.get(key).getMoveForwardCount())) {
                winnerList.add(key);
            }
            if (winnerList.isEmpty()) {
                winnerList.add(key);
            }
        }

        return winnerList;
    }

}
