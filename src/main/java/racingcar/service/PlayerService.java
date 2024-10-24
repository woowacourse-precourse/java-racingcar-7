package racingcar.service;

import java.util.List;

public class PlayerService {

    public List<String> splitPlayer(String input) {
        List<String> players = List.of(input.split(","));
        NameValidator.validatePlayerName(players);
        return players;
    }
}
