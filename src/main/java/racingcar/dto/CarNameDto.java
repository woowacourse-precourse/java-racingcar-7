package racingcar.dto;

public record CarNameDto(String name) {

    public static CarNameDto of(String name) {
        return new CarNameDto(name);
    }
}
