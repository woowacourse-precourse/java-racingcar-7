package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.enums.ValidationMsg;
import racingcar.dto.RacingCarInitDto;
import racingcar.service.RacingCarService;
import racingcar.service.StringUtilService;
import racingcar.service.ValidatorService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingcarController {
    private final InputView inputView;
    private final ValidatorService validatorService = ValidatorService.getInstance();
    private StringUtilService stringUtilService = StringUtilService.getInstance();
    private RacingCarService racingCarService = RacingCarService.getInstance();

    private List<String> carNameList = new ArrayList<>();
    private Integer inputCarRaceTimes = 0;

    private final OutputView outputView;

    // start: singleton holer
    private RacingcarController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private static class InnerRacingcarController {
        private static final RacingcarController INSTANCE = new RacingcarController();
    }

    public static RacingcarController getInstance() {
        return InnerRacingcarController.INSTANCE;
    }
    // end: singleton holer

    public void playGame() {
//        printMenu();
        setCarNameList(validateCarNames(inputView.requestInputCarName()));
        setInputCarRaceTimes(validateCarRaceTimes(inputView.requestInputCarRaceTimes()));
        initSaveRacingCar();
        System.out.println(InterfaceMsg.PRINT_OUT.getValue());
        outputView.printCarRacing(racingCarService.playCarRacing());
        outputView.printCarRacing(racingCarService.carRacingResult());
    }

//    private void printMenu() {
//
//    }

    private List<String> validateCarNames(String inputCarName) throws IllegalArgumentException {
        ValidationMsg validationMsg = validatorService.validationCarName(inputCarName);
        if (validationMsg != ValidationMsg.PROPER_TYPE) {
            throw new IllegalArgumentException(validationMsg.getValue());
        }

        return stringUtilService.splitByComma(inputCarName);
    }

    public void setCarNameList(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }

    public void setInputCarRaceTimes(Integer inputCarRaceTimes) {
        this.inputCarRaceTimes = inputCarRaceTimes;
    }

    public Integer getInputCarRaceTimes() {
        return inputCarRaceTimes;
    }


    private Integer validateCarRaceTimes(String inputCarRaceTimes) {
        Integer properCarRaceTimes = 0;
        try {
            properCarRaceTimes = this.properCarRaceTimes(inputCarRaceTimes);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); inputCarRaceTimes = requestInputCarRaceTimes();
            return validateCarRaceTimes(inputCarRaceTimes);
        }
        return properCarRaceTimes;
    }

    private String requestInputCarRaceTimes() {
        System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue());
        String inputCarRaceTimes = readLine();
        System.out.println(inputCarRaceTimes); // Player로부터 자동차 경주의 회수를 입력받음

        return inputCarRaceTimes;
    }

    private Integer properCarRaceTimes(String inputCarRaceTimes) throws IllegalArgumentException {
        ValidationMsg validationMsg = validatorService.validationCarRaceTimes(inputCarRaceTimes);
        if (validationMsg != ValidationMsg.PROPER_TYPE) {
            throw new IllegalArgumentException(validationMsg.getValue());
        }
        return Integer.valueOf(inputCarRaceTimes);
    }

    private void initSaveRacingCar() {
        RacingCarInitDto racingCarInitDto = RacingCarInitDto.builder()
                .carNameList(this.getCarNameList())
                .inputCarRaceTimes(this.getInputCarRaceTimes())
                .build();
        racingCarService.initSaveRacingCar(racingCarInitDto);
    }
}
