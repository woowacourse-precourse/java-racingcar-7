package racingcar;

import racingcar.presenters.ApplicationPresenter;

public class Application {
    public static void main(String[] args) {
        ApplicationPresenter presenter = new ApplicationPresenter();
        presenter.init();
        presenter.runGame();
        presenter.displayResults();
    }
}
