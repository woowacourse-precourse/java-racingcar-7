package racingcar.util;

import racingcar.repository.GameRepository;
import racingcar.repository.RoundRepository;

public class DependencyFactory {
    public static void initialize() {
        RoundRepository roundRepository = RoundRepository.getInstance();
        GameRepository gameRepository = GameRepository.getInstance();
        DataRelationUtil dataRelationUtil = DataRelationUtil.getInstance();

        dataRelationUtil.setRepository(roundRepository, gameRepository);
        gameRepository.setDataRelationUtil(dataRelationUtil);
        roundRepository.setDataRelationUtil(dataRelationUtil);
    }
}
