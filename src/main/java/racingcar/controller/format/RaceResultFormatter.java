package racingcar.controller.format;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.race.Race;

public class RaceResultFormatter {

    public RaceResultFormatter() {
    }

    public String convertRaceProgressToString(List<Race> races) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Race race : races) {
            stringBuilder.append(getRaceMoveStrings(race));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String convertWinnersToString(List<Car> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winners) {
            stringBuilder.append(" ");
            stringBuilder.append(car.getMember().getName());
            stringBuilder.append(",");
        }
        if (!stringBuilder.isEmpty()) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private String getRaceMoveStrings(Race race) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : race.getCars()) {
            stringBuilder.append(getIndividualRaceMoveString(car));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private String getIndividualRaceMoveString(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getMember().getName()).append(" : ");
        for (long l = 0; l < car.getRacingDistance(); l++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
