package racingcar.user;

public class SettingGameUser {
    public static UserInfo[] user;

    public SettingGameUser(String[] result) {
        user = new UserInfo[result.length];
        for (int i = 0; i < result.length; i++) {
            user[i] = new UserInfo(result[i]);
        }
    }
}
