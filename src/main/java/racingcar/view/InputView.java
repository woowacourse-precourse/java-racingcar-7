package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private static InputView inputView;
    private String carNames;
    private String tryCount;

    private InputView(){
    }

    public static InputView getInstance(){
        if(inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public void readCarRacingSetup(){
        readCarNames();
        readTryCount();
    }

    private void readCarNames(){
        System.out.println(CAR_NAME_MESSAGE);
        setCarNames(Console.readLine());
    }

    private void readTryCount(){
        System.out.println(TRY_COUNT_MESSAGE);
        setTryCount(Console.readLine());
    }

    private void setCarNames(String carNames) {
        this.carNames = carNames;
    }

    public String getCarNames() {
        return carNames;
    }
    private void setTryCount(String tryCount) {
        this.tryCount = tryCount;
    }

    public String getTryCount() {
        return tryCount;
    }

    public void close(){
        if(inputView != null){
            inputView = null;
        }
        Console.close();
    }
}