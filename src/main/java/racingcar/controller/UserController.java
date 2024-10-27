package racingcar.controller;

import racingcar.user.UserObject;
import racingcar.validator.Validator;

public class UserController {
    private String inputString;
    private UserObject[] user;
    private Validator validator;

    public UserController(String inputString) {
        this.inputString = inputString;
        this.validator = new Validator(inputString);
    }

    public UserObject[] settingUser() {
        validator.isEmptyInput();
        validator.isCommaInFrontorBack();
        parsingInputString();
        return user;
    }

    private void parsingInputString() {
        String[] parsingUser = inputString.split(",");
        createUser(parsingUser);
    }

    private void createUser(String[] parsingUser) {
        user = new UserObject[parsingUser.length];
        createUserObject(parsingUser);
    }

    private void createUserObject(String[] parsingUser) {
        for (int i = 0; i < parsingUser.length; i++) {
            validator.userNameValidate(parsingUser[i].trim());
            user[i] = new UserObject(parsingUser[i]);
        }
    }
}
