package racingcar.controller;

/**
 * View와 Service 사이를 연결하는 객체 :
 * InputView에서 입력값을 받아 주요 model 객체를 생성하여
 * Service에 전달하고 결과 값을 요청하여 출력을 위해 OutputView에 전달하는 역할
 */
public interface RacingController {

    void run();
}
