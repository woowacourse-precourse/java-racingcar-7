package racingcar.iohandler;

import camp.nextstep.edu.missionutils.Console;
import racingcar.User;

import java.util.ArrayList;
import java.util.List;

import static racingcar.User.createUser;

public class InputHandler {

    public List<User> getCarNamesFromUser() {
        String input = Console.readLine();
        String[] names = input.split(",");
        List<User> users = new ArrayList<>();
        for (String name : names) {
            User user = createUser(name);
            users.add(user);
        }
        return users;
    }

    public int getMoveCountFromUser() {
        String input = Console.readLine();
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("숫자만 입력 해 주세요.");
        }
        return Integer.parseInt(input);
    }
}
