package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.User.createUser;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] nameList = names.split(",");
        List<User> users = new ArrayList<>();
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            User user = createUser(name);
            users.add(user);
        }

        System.out.println("시도할 횟수는 몇 회 인가요?");
        String times = Console.readLine();
        boolean isNumeric = times.chars().allMatch(Character::isDigit);
        if (isNumeric) {
            throw new IllegalArgumentException("숫자만 입력 해 주세요.");
        }
        long time = Long.parseLong(times);



    }
}
