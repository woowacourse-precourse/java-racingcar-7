package racingcar;

public class GameController {

    private final CarService carService;

    public GameController() {
        this.carService = DependencyInjectionConfig.carService();
    }


    public void playGame(RequestDto requestDto) {
        carService.doGameTotalSet(requestDto.getCarNames(), requestDto.getTryCount());
    }


    public Model getResult() {
        Model model = carService.getResultModel();
        carService.doneGame();
        return model;

    }





}
