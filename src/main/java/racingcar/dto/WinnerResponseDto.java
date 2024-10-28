package racingcar.dto;

public record WinnerResponseDto(
        String name,
        int position
) {
    public static WinnerResponseDto of(final String name, final int position) {
        return new WinnerResponseDto(name, position);
    }
}
