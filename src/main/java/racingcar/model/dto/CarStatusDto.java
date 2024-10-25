package racingcar.model.dto;

public record CarStatusDto(String name, int position) {

    public static CarStatusDto of(String name, int position) {
        return new CarStatusDto(name, position);
    }
}
