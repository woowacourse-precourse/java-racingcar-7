package racingcar;

import java.util.Set;

public class RaceResult {
    private final CarRegistry carRegistry;
    private final StringBuilder result;

    public RaceResult(StringBuilder result, CarRegistry registry) {
        this.result = result;
        this.carRegistry = registry;
    }

    public RaceResult add(String result) {
        this.result.append(result);
        return this;
    }

    public String winnersToString() {
        Set<String> winners = carRegistry.getWinnerNames();
        String winnersString = "최종 우승자 : " + String.join(", ", winners);
        return winnersString;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
