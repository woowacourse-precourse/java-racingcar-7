package racingcar.controller;

import java.util.Arrays;
import racingcar.user.UserObject;
import racingcar.validator.Validator;

public class UserController {
    private String inputString;
    private UserObject[] users;
    private Validator validator;

    public UserController(String inputString) {
        this.inputString = inputString;
        this.validator = new Validator(this.inputString);
    }

    public UserObject[] initializeUsers() {
        validateInput();
        String[] parsedUserNames = inputString.split(",");
        createUserObjects(parsedUserNames);
        return users;
    }
    
    private void validateInput() {
        validator.userInputValidate();
    }

    private void createUserObjects(String[] parsedUserNames) {
        users = Arrays.stream(parsedUserNames)
                .map(String::trim)
                .peek(validator::userNameValidate)
                .map(UserObject::new)
                .toArray(UserObject[]::new);
    }
}
