package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputManager inputManager = new InputManager();
        GameManager gameManager = new GameManager();

        String[] car_list;
        int try_count;

        try{
            car_list = inputManager.GetCarList();
            try_count = inputManager.GetTryCount();
        }catch (Exception e){
            throw new IllegalArgumentException();
        }

        inputManager.PrintResult(
                gameManager.startGame(car_list, try_count));

    }
}
