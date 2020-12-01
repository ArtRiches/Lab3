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
                getName(), fed ? "уже сытый" : "еще голдный"
        );
        return fed;
    }

    public void eat() {
        this.fed = true;
        System.out.printf("%s поел(а) и теперь не голодный(ая)%n", getName());
    }

    public boolean isTookFishOil() {
        System.out.printf(
                "%s %s%n",
                getName(),
                tookFishOil ? "уже принял(а) рыбий жир" : "еще не принял(а) рыбий жир"
        );
        return tookFishOil;
    }

    public void takeFishOil() {
        this.tookFishOil = true;
        System.out.printf("%s принял(а) рыбий жир%n", getName());
    }

    @Override
    public String toString() {
        return String.format(
                "Животное Ребенок: %s, %s, %s",
                getName(),
                tookFishOil ? "принял(a) рыбий жир" : "не принял рыбий жир",
                fed ? "сытый(ая)" : "голодный(ая)"
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
