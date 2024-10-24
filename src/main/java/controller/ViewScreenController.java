package controller;

import dto.CarDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.GameManager;
import view.ViewScreen;

public class ViewScreenController {
    private final GameManager gameManager;
    private final ViewScreen viewScreen;

    public ViewScreenController() {
        this.viewScreen = new ViewScreen();
        this.gameManager = this.getGameManager();
        startGame();
    }

    private GameManager getGameManager() {
        List<String> input = this.viewScreen.getInput();
        String carNames = this.checkNameFormat(input.get(0));
        List<String> carNameList = Arrays.asList(carNames.split(","));
        int runTimes = this.checkRunTimesFormat(input.get(1));
        return new GameManager(carNameList, runTimes);

    }

    private void nullCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    // Todo 자동차 이름 양식 체크 & 양식 정리
    public String checkNameFormat(String input) {
        nullCheck(input);
        return input;
    }

    // Todo runTimes 양식 체크
    public int checkRunTimesFormat(String input) {
        nullCheck(input);
        return Integer.parseInt(input);
    }

    // 경주 게임 전체 관리
    private void startGame() {
        //경주 게임 진행
        List<List<CarDTO>> racingProgressInfo = this.gameManager.raceGameManage();
        viewScreen.customPrint(System.lineSeparator() + "실행 결과" + System.lineSeparator());
        for (List<CarDTO> cars : racingProgressInfo) {
            for (CarDTO car : cars) {
                viewScreen.printRace(car.getName(), car.getDistance());
            }
            viewScreen.customPrint(System.lineSeparator());
        }

        // 승자 구분
        List<CarDTO> winnerList = this.gameManager.getWinner();
        List<String> winnerNameList = new ArrayList<>();
        for (CarDTO winner : winnerList) {
            winnerNameList.add(winner.getName());
        }

        viewScreen.printWinner(winnerNameList);
    }

}
