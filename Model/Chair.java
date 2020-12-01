package Model;

import java.util.Objects;

public class Chair {
    private boolean down;

    public boolean isDown() {
        return down;
    }

    public void makeDown(Animal animal, ActionIntent actionIntent) {
        this.down = true;
        System.out.printf("%s %s ���������� ����%n", animal.getName(), actionIntent);
    }

    @Override
    public String toString() {
        return String.format(
                "����: %s",
                down ? "����������" : "�����"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return down == chair.down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(down);
    }
}
