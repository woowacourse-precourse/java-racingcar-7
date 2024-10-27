package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public final class GameView {
    public String getCarNamesInput() {
        return Console.readLine().trim();
    }
}
