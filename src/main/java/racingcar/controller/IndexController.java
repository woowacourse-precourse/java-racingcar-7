package racingcar.controller;

import java.util.NoSuchElementException;
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
        try {
            return inputView.getCarsName();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    public int displayRaceLapInputPage() {
        try {
            return inputView.getLapCount();
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
