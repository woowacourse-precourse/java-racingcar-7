package racingcar;
import java.util.List;

public interface Printer {
	void printStatus(List<Car> cars);
    void printWinners(List<Car> cars);
}
