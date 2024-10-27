package racingcar.application.dto;

public record RacingGameResponse(String result) implements Response {
    @Override
    public String getValue() {
        return result;
    }
}
