package racingcar.service;

import java.util.List;
public class RacingcarService {

    public List<String> parseCarName(String rawCarName) {
        return List.of(rawCarName.split(","));
    }

}
