package racingcar.io.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class RacePositionConsoleView implements RacePositionView {
    private static final RacePositionConsoleView INSTANCE = new RacePositionConsoleView();
    private static final String DISTANT_UNIT_DISPLAY = "-";
    private static final String COLON = " : ";
    private static final String LINE_BREAK = "\n";

    private RacePositionConsoleView() {
    }

    public static RacePositionConsoleView getInstance() {
        return INSTANCE;
    }

    public void showRacePosition(CarsDto racePositionDto) {
        System.out.print(generatePositionString(racePositionDto));
    }

    private String generatePositionString(CarsDto carDto) {
        StringBuilder positionString = new StringBuilder(LINE_BREAK);
        carDto.carDtoList()
                .forEach(car -> positionString.append(generateSinglePositionString(car)));
        return positionString.toString();
    }

    private String generateSinglePositionString(CarDto car) {
        String nameString = car.name();
        String distanceString = generateDistanceString(car.position());
        return nameString + COLON + distanceString + LINE_BREAK;
    }

    private String generateDistanceString(int distance) {
        return DISTANT_UNIT_DISPLAY.repeat(Math.max(0, distance));
    }
}
