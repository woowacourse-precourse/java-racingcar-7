package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class WoowaUserInput implements UserInputHandler {
    @Override
    public String makeUserInputNames() {
        return null;
    }

    @Override
    public int makeUserInputRoundNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
