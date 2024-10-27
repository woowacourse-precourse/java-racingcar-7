package racingcar.io.read;

public abstract class AbstractReader<T> implements Reader<T> {

    protected String readString() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }

}
