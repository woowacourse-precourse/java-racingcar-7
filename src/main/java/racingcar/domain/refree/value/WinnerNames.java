package racingcar.domain.refree.value;

import racingcar.domain.car.value.Name;

import java.util.ArrayList;
import java.util.List;

public class WinnerNames {

    private final List<Name> winnerNames;

    public WinnerNames(List<Name> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public static WinnerNames from(List<Name> winnerNames) {
        return new WinnerNames(winnerNames);
    }

    @Override
    public String toString() {
        StringBuilder formBuilder = new StringBuilder();
        for (Name name : winnerNames) {
            formBuilder.append(name)
                    .append(",");
        }

        formBuilder.deleteCharAt(formBuilder.length() - 1);
        return formBuilder.toString();
    }
}
