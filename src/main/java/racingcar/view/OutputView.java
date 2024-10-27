package racingcar.view;

import racingcar.model.Race;

public class OutputView {
    private static final String SHAPE_OF_POSITION = "-";
    private static final String OUTPUT_FORMAT_OF_RACE = "%s : %s\n";
    private static final String OUTPUT_FORMAT_OF_WINNER = "최종 우승자 : %s\n";
    private static final String DELIMITER = ", ";
    private static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_MESSAGE = "실행결과";

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

    public void printInputCarNameMessage(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputCountMessage(){
        System.out.println(INPUT_COUNT_MESSAGE);
    }

    public void printResultMessage(){
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }
}
