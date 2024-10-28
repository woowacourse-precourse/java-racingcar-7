package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.enums.InterfaceMsg;
import racingcar.domain.enums.ValidationMsg;
import racingcar.dto.RacingCarDto;
import racingcar.dto.RacingCarInitDto;
import racingcar.service.RacingCarService;
import racingcar.service.StringUtilService;
import racingcar.service.ValidatorService;

public class RacingcarController {
    private ValidatorService validatorService = ValidatorService.getInstance();
    private StringUtilService stringUtilService = StringUtilService.getInstance();
    private RacingCarService racingCarService = RacingCarService.getInstance();
    private List<String> carNameList = new ArrayList<>();
    private Integer inputCarRaceTimes = 0;
    private RacingCarDto racingCarDto;

    // start: Singleton Holder
    private RacingcarController() {
    }

    private static class InnerComputerService {
        private static final RacingcarController instance = new RacingcarController();
    }

    public static RacingcarController getInstance() {
        return InnerComputerService.instance;
    }
    // end: Singleton Holder

    public List<String> getCarNameList() {
        return carNameList;
    }

    public void setCarNameList(List<String> carNameList) {
        this.carNameList = carNameList;
    }

    public Integer getInputCarRaceTimes() {
        return inputCarRaceTimes;
    }

    public void setInputCarRaceTimes(Integer inputCarRaceTimes) {
        this.inputCarRaceTimes = inputCarRaceTimes;
    }

    public void initOperator() {
        this.printMenu();
    }

    private void printMenu() {
        this.requestUserInput();
        this.initSaveRacingCar();
        System.out.println(InterfaceMsg.PRINT_OUT.getValue());
        racingCarService.playCarRacing();
        racingCarService.printCarRacingResult();
    }

    private void requestUserInput() {
        this.setCarNameList(this.validateCarNames(this.requestInputCarName()));
        this.setInputCarRaceTimes(this.validateCarRaceTimes(this.requestInputCarRaceTimes()));
    }

    private String requestInputCarName() {
        System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue());
        String inputCarName = readLine();
        System.out.println(inputCarName); // Player로부터 자동차 이름들을 입력받음

        return inputCarName;
    }

    private String requestInputCarRaceTimes() {
        System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue());
        String inputCarRaceTimes = readLine();
        System.out.println(inputCarRaceTimes); // Player로부터 자동차 경주의 회수를 입력받음

        return inputCarRaceTimes;
    }

    /**
     * 유효성을 통과할 때까지 사용자로부터 자동차 이름들을 입력받는다. 유효성을 통과할 때 List<String>를 반환
     * @param inputCarName : String
     * @return properCarNameList : List<String>
     */
    private List<String> validateCarNames(String inputCarName) {
        List<String> properCarNameList = new ArrayList<>();
        try {
            properCarNameList = this.properCarNameList(inputCarName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); inputCarName = requestInputCarName();
            return validateCarNames(inputCarName);
        }
        return properCarNameList;
    }

    private List<String> properCarNameList(String inputCarName) throws IllegalArgumentException {
        ValidationMsg validationMsg = validatorService.validateCarName(inputCarName);
        if (validationMsg != ValidationMsg.PROPER_TYPE) {
            throw new IllegalArgumentException(validationMsg.getValue());
        }

        return stringUtilService.splitByComma(inputCarName);
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
