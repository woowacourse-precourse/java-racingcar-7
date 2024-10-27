package racingcar;

import racingcar.service.ApplicationService;

public class Application {

    private final ApplicationService applicationService;

    public Application() {
        this.applicationService = new ApplicationService();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    public void run() {
        this.applicationService.run();
    }
}
