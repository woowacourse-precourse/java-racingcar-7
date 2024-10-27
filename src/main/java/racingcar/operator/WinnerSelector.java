package racingcar.operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.user.SettingGameUser;
import racingcar.user.UserObject;

public class WinnerSelector {
    UserObject[] user;

    public List<String> getTopScores() {
        int maxScore = Arrays.stream(user)
                .mapToInt(UserObject::getUserScore)
                .max()
                .orElse(Integer.MIN_VALUE);
        return Arrays.stream(user)
                .filter(u -> u.getUserScore() == maxScore)
                .map(UserObject::getUserName)
                .collect(Collectors.toList());
    }

    public WinnerSelector() {
        this.user = SettingGameUser.user;
    }
}
