package racingcar.view;

public class InputView {
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_PLAY_TIMES = "시도할 회수는 몇회인가요?";
    public InputView(){
    }
    public void inputCarName(){
        System.out.println(INPUT_CAR_NAME);
    }

    public void inputPlayTimes(){
        System.out.println(INPUT_PLAY_TIMES);
    }
}
