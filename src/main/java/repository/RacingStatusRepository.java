package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RacingStatusRepository implements Repository {
    private final Map<String, Long> racingStatusRepository;

    public RacingStatusRepository(Map<String, Long> racingStatusRepository) {
        this.racingStatusRepository = racingStatusRepository;
    }

    /**
     * 중복이름 검사
     *
     * @param name : 자동차 이름
     * @return : 중복데이터가 존재하면 true
     */
    @Override
    public Boolean isDuplicateName(String name) {
        return racingStatusRepository.containsKey(name);
    }

    @Override
    public void save(String name, Long moveForwardCount) {
        racingStatusRepository.put(name, moveForwardCount);
    }

    @Override
    public Long find(String name) {
        return racingStatusRepository.get(name);
    }

    @Override
    public int size() {
        return racingStatusRepository.size();
    }

    @Override
    public Set<String> repositoryKeyset() {
        return racingStatusRepository.keySet();
    }

    @Override
    public List<String> findWinner() {
        ArrayList<String> keySet = new ArrayList<>(racingStatusRepository.keySet());
        List<String> winnerList = new ArrayList<>();

        keySet.sort((o1, o2) -> racingStatusRepository.get(o2).compareTo(racingStatusRepository.get(o1)));
        for (String key : keySet) {
            if (!winnerList.isEmpty() && racingStatusRepository.get(winnerList.get(0))
                    .equals(racingStatusRepository.get(key))) {
                winnerList.add(key);
            }
            if (winnerList.isEmpty()) {
                winnerList.add(key);
            }
        }

        return winnerList;
    }

}
