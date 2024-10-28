package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingcarResults {

    private List<RacingcarResult> results;

    public RacingcarResults() {
        this.results = new ArrayList<>();
    }

    public void addResults(String name, int position) {
        results.add(new RacingcarResult(name, position));
    }

    public record RacingcarResult(
            String name,
            int position
    ) {}
}
