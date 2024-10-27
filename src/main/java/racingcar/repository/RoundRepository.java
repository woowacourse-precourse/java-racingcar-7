package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Round;
import racingcar.util.DataRelationUtil;

public class RoundRepository {

    private static RoundRepository instance;
    private DataRelationUtil dataRelationUtil;

    private RoundRepository() {

    }

    public static RoundRepository getInstance() {
        if (instance == null) {
            instance = new RoundRepository();
        }
        return instance;
    }

    private int id = 0;
    private Map<Integer, Round> rounds = new HashMap<>();

    public void save(Round round) {
        round.setId(id);
        rounds.put(id, round);
        dataRelationUtil.roundToGame(round);
        id++;
    }

    public void update(Round round) {
        rounds.replace(round.getId(), round);
        dataRelationUtil.roundToGame(round);
    }

    public Round findByRoundId(int id) {
        return rounds.get(id);
    }

    public void setDataRelationUtil(DataRelationUtil dataRelationUtil) {
        this.dataRelationUtil = dataRelationUtil;
    }
}
