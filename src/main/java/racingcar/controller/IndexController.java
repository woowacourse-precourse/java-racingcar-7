package racingcar.controller;

import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.view.InputView;

public class IndexController {
    //----- 싱글톤 패턴 적용 -----//
    private static final IndexController instance = new IndexController();
    private final InputView inputView = InputView.getInstance();
    private IndexController() {}
    public static IndexController getInstance() {
        return instance;
    }
    //------------------------//

    public CarsSaveRequestDto displayCarsNameInputPage() {
        return inputView.getCarsName();
    }
}
