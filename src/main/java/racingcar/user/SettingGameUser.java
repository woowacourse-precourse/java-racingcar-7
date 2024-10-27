package racingcar.user;

import racingcar.view.InputView;

public class SettingGameUser {
    public static UserObject[] user;

    public SettingGameUser() {
        user = new UserObject[InputView.result.length];
        CreateUser(InputView.result);
    }

    private void CreateUser(String[] result) {
        for (int i = 0; i < result.length; i++) {
            user[i] = new UserObject(result[i]);
        }
    }
}


