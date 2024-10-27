package racingcar.value;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RacingCarList {
    private final List<RacingCar> list;

    public RacingCarList(List<RacingCar> list) {
        this.list = list;
    }

    public void action(final Consumer<RacingCar> action) {
        list.forEach(action);
    }

    public void actionPrint(final Consumer<RacingCarList> action) {
        action.accept(this);
    }

    public WinnerPlayerList getWinnersList() {
        return list.stream()
            .filter(e -> Objects.equals(e.getDistance(), getWinnerDistance()))
            .map(RacingCar::getPlayer)
            .collect(Collectors.collectingAndThen(Collectors.toList(), WinnerPlayerList::new));
    }

    private Distance getWinnerDistance() {
        return this.list.stream()
            .map(RacingCar::getDistance)
            .max(Comparator.comparingLong(Distance::getValue))
            .orElseThrow(IllegalArgumentException::new);
    }
}