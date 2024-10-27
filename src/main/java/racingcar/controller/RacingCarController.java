package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView){
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        receiveCarNames(); // InputView에서 자동차 이름을 받아서 RacingCarService의 Cars 객체 생성
        receiveTryCount(); // InputView에서 TryCount 받아서 RacingCarService 객체에게 전달

        outputView.printStartMessage(); // "실행 결과" 출력

        while(racingCarService.isAvailable()){ // 한 라운드씩 진행하기
            racingCarService.moveCars(); // 각 회차별로 Car 이동
            outputView.printRacingProcess(racingCarService); // 각 회차별 움직인 모습 보여주는 OutputView 메소드 실행
        }

        outputView.printWinners(racingCarService); // winner 보여주는 OutputView 메소드 실행
    }

    public void receiveCarNames(){
        List<String> carNameList = Arrays.stream(inputView.readCarNames().split(",")).toList()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());

        racingCarService.createCars(carNameList);
    }

    public void receiveTryCount() {
        racingCarService.setTryCount(Integer.parseInt(inputView.readTryCounts()));
    }
}
