package racingcar.io.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class RacePositionConsoleView implements RacePositionView {
    private static final RacePositionConsoleView INSTANCE = new RacePositionConsoleView();
    private static final String DISTANT_UNIT_DISPLAY = "-";
    private static final String COLON = " : ";

    private RacePositionConsoleView() {
    }

    public static RacePositionConsoleView getInstance() {
        return INSTANCE;
    }

    public void showRacePosition(CarsDto racePositionDto) {
        racePositionDto.carDtoList().forEach(carDto ->
                System.out.println(generateDisplayStringFrom(carDto)));
    }

    private String generateDisplayStringFrom(CarDto car) {
        String nameString = car.name();
        String distanceString = generateDistanceString(car.position());
        return  nameString + COLON + distanceString;
    }

    private String generateDistanceString(int distance) {
        return DISTANT_UNIT_DISPLAY.repeat(Math.max(0, distance));
    }
}
