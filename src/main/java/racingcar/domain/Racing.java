package racingcar.domain;

import java.util.List;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Racing {

    private Racing() {
    }

    public static Racing of() throws NotImplementedException {
        throw new NotImplementedException("아직 구현되지 않았습니다.");
    }

    public List<Car> getWinners() throws NotImplementedException {
        throw new NotImplementedException("아직 구현되지 않았습니다.");
    }
}
