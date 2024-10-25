package racingcar.dto;

import java.util.List;

public record CarNameRequest(
        List<String> carNameList
) {
    public static CarNameRequest of (List<String> carNameList) {
        return new CarNameRequest(carNameList);
    }
}
