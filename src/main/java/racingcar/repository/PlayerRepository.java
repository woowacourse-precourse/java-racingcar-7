package racingcar.repository;

import java.util.List;
import racingcar.domain.player.Player;

public interface PlayerRepository {
    Player save(Player player);

    Player findById(Long id);

    List<Player> findAll();
}
