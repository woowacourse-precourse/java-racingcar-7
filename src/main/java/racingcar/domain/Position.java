package racingcar.domain;

import racingcar.domain.dto.PositionDTO;

public class Position {

  private int position;

  public Position() {
    this.position = 0;
  }

  public void move() {
    this.position++;
  }

  public PositionDTO toDTO() {
    return new PositionDTO(this.position);
  }
}
