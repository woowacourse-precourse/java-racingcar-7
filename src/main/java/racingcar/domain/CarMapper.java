package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarRace mapCarRaceByName(List<String> names) {

        final List<Car> carList = names.stream()
                .map(name -> new Car(new CarName(name),0))
                .toList();
        return new CarRace(carList);
    }
}
