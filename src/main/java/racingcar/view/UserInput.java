package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import racingcar.view.constant.Request;

public class UserInput {

    public static String request(String infoMessage) {
        System.out.println(infoMessage);
        return readLine();
    }
}
