package racingcar.dto;

public record CarStatusDto(String name, int position) {

    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String MOVE_DASH = "-";

    @Override
    public String toString() {
        return name + NAME_POSITION_SEPARATOR + MOVE_DASH.repeat(position);
    }
}
