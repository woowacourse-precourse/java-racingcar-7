package racingcar.dto;

import racingcar.domain.CarImpl;

public class RoundResultDto {
    private final String result;

    private RoundResultDto(String result) {
        this.result = result;
    }

    public static RoundResultDto from(CarImpl car) {
        String result = String.format("%s : %s", car.getName(), car.toScoreSymbol());
        return new RoundResultDto(result);
    }

    public String getResult() {
        return result;
    }
}
