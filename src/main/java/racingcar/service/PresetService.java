package racingcar.service;

import racingcar.model.Game;
import racingcar.utils.StringUtils;

public class PresetService {
    StringUtils stringUtils = new StringUtils();

    public Game setGame(String sentence) {
        return new Game(this.stringUtils.separateName(sentence));
    }
}
