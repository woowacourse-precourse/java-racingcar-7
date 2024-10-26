package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.entity.RacingCar;

public interface RacingCarRepository {
    
    //TODO: RacingCar에 대한 저장 리포지토리를 정의할 인터페이스
    void save(RacingCar racingCar);
    List<RacingCar> findAll();
    Optional<RacingCar> findByName(String name);
}
