package racingcar.service.racing.dto;

import racingcar.constant.separator.SeparatorConstant;

import java.util.List;

public class RacingResult {
    private final List<String> executeResult;
    public RacingResult(List<String> executeResult) {
        this.executeResult = executeResult;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        executeResult.forEach((result) -> sb.append(result).append(SeparatorConstant.NEXT_LINE));
        return sb.toString();
    }
}
