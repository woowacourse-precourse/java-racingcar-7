package racingcar.controller;

import racingcar.view.View;

public interface Controller<T> {
    View run(T request);
}
