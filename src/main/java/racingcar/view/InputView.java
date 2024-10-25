package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCar() {
        return Console.readLine();
    }

    public int inputRound() {
        return Integer.parseInt(Console.readLine());
    }
}