package Model;

import java.util.Objects;

public class AnimalChild extends Animal {
    private boolean fed;
    private boolean tookFishOil;

    public AnimalChild(String name, boolean tookFishOil) {
        super(name);
        this.tookFishOil = tookFishOil;
    }

    public boolean isFed() {
        System.out.printf(
                "%s %s%n",
                getName(), fed ? "��� �����" : "��� �������"
        );
        return fed;
    }

    public void eat() {
        this.fed = true;
        System.out.printf("%s ����(�) � ������ �� ��������(��)%n", getName());
    }

    public boolean isTookFishOil() {
        System.out.printf(
                "%s %s%n",
                getName(),
                tookFishOil ? "��� ������(�) ����� ���" : "��� �� ������(�) ����� ���"
        );
        return tookFishOil;
    }

    public void takeFishOil() {
        this.tookFishOil = true;
        System.out.printf("%s ������(�) ����� ���%n", getName());
    }

    @Override
    public String toString() {
        return String.format(
                "�������� �������: %s, %s, %s",
                getName(),
                tookFishOil ? "������(a) ����� ���" : "�� ������ ����� ���",
                fed ? "�����(��)" : "��������(��)"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalChild that = (AnimalChild) o;
        return fed == that.fed &&
                tookFishOil == that.tookFishOil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fed, tookFishOil);
    }
}
