package racingcar;

public class GameController {

    private final CarService carService;

    public GameController() {
        this.carService = DependencyInjectionConfig.carService();
    }

    // post
    public void playGame(RequestDto requestDto) {
        carService.doGameTotalSet(requestDto.getCarNames(), requestDto.getTryCount());
    }

    // get
    public Model getResult() {
        return carService.getResultModel();
    }

    public void doneModel() {
        carService.doneGame();
    }



}
