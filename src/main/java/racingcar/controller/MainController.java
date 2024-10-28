package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 해당 클래스는 RacingCar 게임의 서비스를 연결하는 컨트롤러 클래스입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class MainController {

    /**
     * 사용자의 입력을 담당하는 InputView 객체입니다.
     */
    private final InputView inputView;

    /**
     * 사용자에게 출력을 담당하는 OutputView 객체입니다.
     */
    private final OutputView outputView;

    /**
     * 자동차 정보를 저장하는 CarRepository 객체입니다.
     */
    private final CarRepository carRepository;

    /**
     * RacingService 객체입니다.
     */
    private final RacingService racingService;

    /**
     * MainController 객체를 생성합니다.
     */
    public MainController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carRepository = new CarRepository();
        this.racingService = new RacingService(inputView, outputView, carRepository);
    }

    /**
     * 레이싱 게임의 서비스를 실행하는 메서드 입니다.
     */
    public void run() {
        racingService.run();
    }
}
