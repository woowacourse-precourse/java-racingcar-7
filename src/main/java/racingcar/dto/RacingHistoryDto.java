package racingcar.dto;

public class RacingHistoryDto {
    public record RacingHistoryOutputDto(String carName, int roundNumber, int totalMovedDistance) {
    }
}
