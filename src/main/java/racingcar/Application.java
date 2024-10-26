package racingcar;

import racingcar.adapter.in.console.ConsoleHandler;
import racingcar.config.context.ApplicationContext;


public class Application {

    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance(Application.class);

        ConsoleHandler handler = context.getBean(ConsoleHandler.class);
        handler.startRacing();
    }
}
