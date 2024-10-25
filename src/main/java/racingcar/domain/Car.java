package racingcar.domain;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class Car {

    private Car() {
    }

    public static Car of(String name) throws NotImplementedException {
        throw new NotImplementedException("아직 구현되지 않았습니다.");
    }
}
