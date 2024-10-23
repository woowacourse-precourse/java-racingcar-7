package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.service.RacingCarService;
import racingcar.service.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        this.racingCarService = new RacingCarService(createCars());

        TryCount trycount = new TryCount(Integer.parseInt(inputView.readTryCounts()));

        outputView.printStartMessage();

        while(trycount.playOneRound()){
            racingCarService.moveCars(); // 각 회차별로 Car 이동
            outputView.printRacingProcess(racingCarService); // 각 회차별 움직인 모습 보여주는 OutputView 메소드 실행
        }

        outputView.printWinners(racingCarService); // winner 보여주는 OutputView 메소드 실행
    }

    public Cars createCars(){
        List<String> carNameList = Arrays.stream(inputView.readCarNames().split(",")).toList()
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
        return new Cars(carNameList);
    }
}
