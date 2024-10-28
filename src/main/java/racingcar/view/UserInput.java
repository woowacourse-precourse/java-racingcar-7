package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public static String request(String infoMessage) {
        System.out.println(infoMessage);
        return readLine();
    }
}
