package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_RACE_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final String RESULT_MESSAGE = "실행 결과";
    private final String FINAL_RESULT_MESSAGE = "최종 우승자 : ";
    private Service service = new Service();

    public void run(){
        InputCarName();
        Integer count = InputRaceCount();
        goCarMovement(count);
        Output();
    }

    void InputCarName(){
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        service.setCarName();
    }

    private Integer InputRaceCount(){
        System.out.println(INPUT_RACE_COUNT_MESSAGE);
        return setRaceCount();
    }

    private Integer setRaceCount(){
        try {
            String cnt = readLine();
            System.out.println();
            return Integer.parseInt(cnt);
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

    private void goCarMovement(Integer count){
        System.out.println(RESULT_MESSAGE);
        service.goCarMovement(count);
    }

    private void Output() {
        String winner = service.getWinner();
        System.out.print(FINAL_RESULT_MESSAGE + winner);
    }

}
