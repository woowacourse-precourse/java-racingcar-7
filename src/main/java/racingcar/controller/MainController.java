package racingcar.controller;

public class MainController {
    private static ViewController viewController = ViewController.getInstance();

    public static void run(){
        viewController.printGuide();
    }
}
