package racingcar.dto;

public record CarPosition(String carName, int position) {
    private static final String DASH = "-";

    public String getVisualizedStatus() {
        String positionBar =  DASH.repeat(position);
        return carName + " : " + positionBar;
    }
}
