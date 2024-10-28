package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void print(String message) {
        System.out.println(message);
    }

    public String read() {
        return Console.readLine();
    }
}
