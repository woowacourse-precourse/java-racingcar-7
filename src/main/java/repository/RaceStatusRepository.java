package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RaceStatusRepository implements Repository {
    private final Map<String, Long> raceStatusRepository;

    public RaceStatusRepository(Map<String, Long> raceStatusRepository) {
        this.raceStatusRepository = raceStatusRepository;
    }

    /**
     * 중복이름 검사
     *
     * @param name : 자동차 이름
     * @return : 중복데이터가 존재하면 true
     */
    @Override
    public Boolean isDuplicateName(String name) {
        return raceStatusRepository.containsKey(name);
    }

    @Override
    public void save(String name, Long moveForwardCount) {
        raceStatusRepository.put(name, moveForwardCount);
    }

    @Override
    public Long find(String name) {
        return raceStatusRepository.get(name);
    }

    @Override
    public int size() {
        return raceStatusRepository.size();
    }

    @Override
    public Set<String> repositoryKeyset() {
        return raceStatusRepository.keySet();
    }

    @Override
    public List<String> findWinner() {
        ArrayList<String> keySet = new ArrayList<>(raceStatusRepository.keySet());
        List<String> winnerList = new ArrayList<>();

        keySet.sort((o1, o2) -> raceStatusRepository.get(o2).compareTo(raceStatusRepository.get(o1)));
        for (String key : keySet) {
            if (!winnerList.isEmpty() && raceStatusRepository.get(winnerList.get(0))
                    .equals(raceStatusRepository.get(key))) {
                winnerList.add(key);
            }
            if (winnerList.isEmpty()) {
                winnerList.add(key);
            }
        }

        return winnerList;
    }

}
