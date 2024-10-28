package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final GameController gameController;
    private Model model;

    public void input() {
        String line = Console.readLine();
        String[] carNames = line.split(",");
        int tryCount = Integer.parseInt(Console.readLine());

        RequestDto requestDto = new RequestDto(carNames, tryCount);
    }

    public View(){
        this.gameController = DependencyInjectionConfig.gameController();
    }

}
