package racingcar.view;

import racingcar.model.Race;

public class OutputView {
    private static final String SHAPE_OF_POSITION = "-";
    private static final String OUTPUT_FORMAT_OF_RACE = "%s : %s\n";
    private static final String OUTPUT_FORMAT_OF_WINNER = "최종 우승자 : %s\n";
    private static final String DELIMITER = ", ";

    public void printRace(Race race) {
        race.getCars().stream().forEach(car -> {
            String visualPosition = SHAPE_OF_POSITION.repeat(car.getPosition());
            System.out.printf(OUTPUT_FORMAT_OF_RACE, car.getName(), visualPosition);
        });

        System.out.println();
    }

    public void printWinner(Race race) {
        System.out.printf(OUTPUT_FORMAT_OF_WINNER, String.join(DELIMITER, race.getWinner()));
    }
}
