package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Race;

/**
 * packageName    : racingcar.domain.repository
 * fileName       : RaceRepository
 * author         : ehgur
 * date           : 2024-10-25
 * description    : Race 저장소
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-25        ehgur             최초 생성
 */

public class RaceRepository {
    //----- 싱글톤 패턴 적용 -----//
    private static final RaceRepository instance = new RaceRepository();
    private RaceRepository(){}
    public static RaceRepository getInstance() {
        return instance;
    }
    //----- 싱글톤 패턴 적용 -----//

    private final List<Race> raceRepository = new ArrayList<>();

    public void save(Race race) {
        raceRepository.add(race);
    }

    public Race findById(int id) {
        return raceRepository.get(id);
    }

    public void deleteAll() {
        raceRepository.clear();
    }
}
