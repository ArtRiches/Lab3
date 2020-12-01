package Model;

import java.util.Objects;

public class Cup {
    private final Animal owner;
    private boolean full;

    public Cup(Animal owner) {
        this.owner = owner;
    }

    public void fill(Animal animal) {
        full = true;
        System.out.printf("%s наполнил(а) чашку %s%n", animal.getName(), owner.getName());
    }
    
    public void use() {
        full = false;
        System.out.printf("%s выпил(a) содержимое чашки%n", owner.getName());
    }

    public boolean isFull() {
        return full;
    }

    @Override
    public String toString() {
        return String.format(
                "Чашка: владелец %s",
                owner.getName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cup cup = (Cup) o;
        return full == cup.full &&
                Objects.equals(owner, cup.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, full);
    }
}
