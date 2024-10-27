package racingcar.dto;

public record CarStatusDto(String name, int position) {

    private static final String NAME_POSITION_SEPARATOR = " : ";
    private static final String POSITION_MAKER = "-";

    @Override
    public String toString() {
        return name + NAME_POSITION_SEPARATOR + POSITION_MAKER.repeat(position);
    }
}
