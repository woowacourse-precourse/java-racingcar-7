package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import vehicle.Vehicle;

public class RacingCarRepository implements Repository{
    private final Map<String, Vehicle> racingCarRepository;

    public RacingCarRepository(Map<String, Vehicle> racingStatusRepository) {
        this.racingCarRepository = racingStatusRepository;
    }

    /**
     * 중복이름 검사
     *
     * @param name : 자동차 이름
     * @return : 중복데이터가 존재하면 true
     */
    public Boolean isDuplicateName(String name) {
        return racingCarRepository.containsKey(name);
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


    public Set<String> repositoryKeyset() {
        return racingCarRepository.keySet();
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
