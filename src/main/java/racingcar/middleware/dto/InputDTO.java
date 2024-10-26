package racingcar.middleware.dto;

import java.util.List;

public record InputDTO(
        List<String> carNames,
        long lapCount
) {
    public static InputDTO of(final List<String> carNames, final long lapCount) {
        return new InputDTO(carNames, lapCount);
    }

    @Override
    public List<String> carNames() {
        return carNames;
    }

    @Override
    public long lapCount() {
        return lapCount;
    }
}
