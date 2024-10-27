package racingcar.domain.race;

import racingcar.domain.car.CarRegistry;

import java.util.Set;

public class RaceResult {
    private final CarRegistry carRegistry;
    private final StringBuilder result;
    private final WinnerDecider winnerDecider;

    public RaceResult(StringBuilder result, CarRegistry registry) {
        this.result = result;
        this.carRegistry = registry;
        this.winnerDecider = new WinnerDecider();
    }

    public RaceResult add(String result) {
        this.result.append(result).append("\n");
        return this;
    }

    public String winnersToString() {
        Set<String> winners = winnerDecider.getWinners(carRegistry.getCars());
        String winnersString = "최종 우승자 : " + String.join(", ", winners);
        return winnersString;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
