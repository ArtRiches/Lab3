package Model;

public class Cone {
    public void hurl(Animal performer, Animal target) {
        System.out.printf("%s �����(�) ����� � %s%n", performer.getName(), target.getName());
    }

    @Override
    public String toString() {
        return "�����";
    }
}
