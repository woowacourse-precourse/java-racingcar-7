package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class View {
    private final GameController gameController;
    private Model model;

    private int tryCount;

    public void input() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        String[] carNames = line.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        tryCount = Integer.parseInt(Console.readLine());

        RequestDto requestDto = new RequestDto(carNames, tryCount);
        gameController.playGame(requestDto);
    }

    public void output() {
        model = gameController.getResult();
        Map<String, ArrayList<Integer>> carMap = model.getCarMap();
        List<String> winner = model.getWinner();

        printRaceRounds(tryCount, carMap);
        printWinners(winner);
    }

    private void printRaceRounds(int maxRounds, Map<String, ArrayList<Integer>> carMap) {
        for (int round = 0; round < maxRounds; round++) {
            printRoundResult(round, carMap);
            System.out.println();  // 각 라운드마다 줄 바꿈
        }
    }

    private void printRoundResult(int round, Map<String, ArrayList<Integer>> carMap) {

        for (Map.Entry<String, ArrayList<Integer>> entry : carMap.entrySet()) {
            String name = entry.getKey();
            ArrayList<Integer> moves = entry.getValue();

            System.out.print(name + " : ");
            int moveCount = (round < moves.size()) ? moves.get(round) : 0;
            System.out.println("-".repeat(moveCount));
        }

    }

    private void printWinners(List<String> winner) {
        System.out.println("최종 우승자: " + String.join(", ", winner));
    }

    public View(){
        this.gameController = DependencyInjectionConfig.gameController();
    }

}
