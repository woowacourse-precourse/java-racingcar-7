package racingcar.io.read;

public abstract class AbstractReader<T> implements Reader<T> {

    protected String readString() {
        String read = camp.nextstep.edu.missionutils.Console.readLine();
        camp.nextstep.edu.missionutils.Console.close();
        return read;
    }

}
