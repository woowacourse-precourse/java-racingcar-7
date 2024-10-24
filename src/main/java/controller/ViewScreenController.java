package controller;

import static java.lang.Integer.parseInt;

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
        List<String> carNameList = this.checkNameFormat(input.get(0));
        int runTimes = this.checkRunTimesFormat(input.get(1));
        return new GameManager(carNameList, runTimes);

    }

    private void nullCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> checkNameFormat(String input) {
        nullCheck(input);
        String inputWithoutSpace = input.replaceAll("\\s+", "");
        List<String> nameList = Arrays.asList(inputWithoutSpace.split(","));
        for (String name : nameList) {
            nullCheck(name);
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (!name.matches("[a-zA-Z가-힣]+")) {
                throw new IllegalArgumentException();
            }
        }
        return nameList;

    }

    public int checkRunTimesFormat(String input) {
        nullCheck(input);
        String inputWithoutSpace = input.replaceAll("\\s+", "");
        try {
            int runTimes = parseInt(inputWithoutSpace);

            if (runTimes < 0) {
                throw new IllegalArgumentException(); //음수일 때 에러
            }

            return runTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e); // 숫자 형식 아닐 때 에러
        }

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
