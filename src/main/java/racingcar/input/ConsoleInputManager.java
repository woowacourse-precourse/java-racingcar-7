package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import racingcar.car.Car;

public class ConsoleInputManager implements InputManager {

    @Override
    public List<Car> getCars() {
        String input = Console.readLine();
        List<String> names = Stream.of(input.split(","))
                .map(String::trim)
                .toList();
        NameValidator.validate(names);
        return names.stream().map(Car::new).toList();
    }

    @Override
    public long getAttemptCount() {
        long count = Long.parseLong(Console.readLine());
        AttemptCountValidator.validate(count);
        return count;
    }
}
