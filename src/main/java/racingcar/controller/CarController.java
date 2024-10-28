package racingcar.controller;

import java.util.NoSuchElementException;
import racingcar.domain.dto.CarsSaveRequestDto;
import racingcar.service.CarService;
import racingcar.view.InputView;

/**
 * packageName    : racingcar.controller
 * fileName       : CarController
 * author         : ehgur
 * date           : 2024-10-27
 * description    : Car에 관련된 api 관리
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-27        ehgur             최초 생성
 */

public class CarController {
    //----- 싱글톤 패턴 적용 -----//
    private static final CarController instance = new CarController();
    private final InputView inputView = InputView.getInstance();
    private final CarService carService = CarService.getInstance();

    private CarController() {
    }

    public static CarController getInstance() {
        return instance;
    }
    //------------------------//

    public void displayCarsNameInputPage() {
        try {
            CarsSaveRequestDto carsRequestDto = inputView.getCarsName();
            carService.isCarNameValid(carsRequestDto);
            carService.saveAll(carsRequestDto);

        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }
}
