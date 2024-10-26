package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        // return Console.readLine();
        return scanner.nextLine();
    }
}
