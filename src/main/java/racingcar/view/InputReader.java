package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    private final OutputWriter outputWriter; // 의존성을 주입받음

    public InputReader(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public String inputRacingCarNames() {

        outputWriter.printCarNamesInputMessage();
        String inputtedRacingCarNames = Console.readLine();
        //예외처리 코드 추가 예정

        return inputtedRacingCarNames;
    }

    public Integer inputRacingCount() {

        outputWriter.printRaceCountInputMessage();
        String inputtedRacingCount = Console.readLine();
        //예외처리 코드 추가 예정
        int racingCount = Integer.parseInt(inputtedRacingCount);

        return racingCount;
    }

}
