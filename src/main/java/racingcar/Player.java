package racingcar;

public class Player
{
    private final String name;
    private int position = 0;

    public Player(String name)
    {
        if (name.length() > 5)
        {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move()
    {
        position++;
    }

    public String getName()
    {
        return name;
    }

    public int getPosition()
    {
        return position;
    }

    public String getPositionIndicator()
    {
        return "-".repeat(position);
    }
}
