package racingcar.user;

public class SettingGameUser {
    public static UserObject[] user;

    public SettingGameUser(String[] result) {
        user = new UserObject[result.length];
        for (int i = 0; i < result.length; i++) {
            user[i] = new UserObject(result[i]);
        }
    }
}

