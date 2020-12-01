import Model.*;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Story {
    public static void main(String[] args) {
        AnimalParent kenga = (AnimalParent) create(new AnimalParent("Кенга"));
        AnimalChild ry = (AnimalChild) create(new AnimalChild("Ру", true));
        AnimalChild tigra = (AnimalChild) create(new AnimalChild("Тигра", false));
        AnimalChild[] children = {ry, tigra};
        nl();
        Chair[] chairs = new Chair[3];
        for (int i = 0; i < chairs.length; i++) {
            chairs[i] = (Chair) create(new Chair());
        }
        nl();
        Cup tigraCup = (Cup) create(new Cup(tigra));
        tigraCup.fill(kenga);
        nl();
        for (AnimalChild child : children) {
            child.isTookFishOil();
        }
        nl();
        tigraCup.use();
        tigra.takeFishOil();
        nl();
        for (AnimalChild child : children) {
            child.isTookFishOil();
        }
        nl();
        BiConsumer<Animal, Animal> push = (performer, target) ->
                System.out.printf(
                        "%s дружески толкнул(а) %s%n",
                        performer.getName(),
                        target.getName()
                );
        ry.setAction(() -> push.accept(ry, tigra));
        tigra.setAction(() -> push.accept(tigra, ry));
        makeActions(children);
        nl();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        nl();
        ry.setAction(() -> chairs[0].makeDown(ry, ActionIntent.ESPECIALLY));
        tigra.setAction(() -> {
            Random random = new Random();
            int chairCount = random.nextInt(2) + 2;
            for (int i = 1; i < chairCount; i++) {
                chairs[i].makeDown(tigra, ActionIntent.ACCIDENTALLY);
            }
        });
        makeActions(children);
        nl();
        for (Chair chair : chairs) {
            System.out.println(chair);
        }
        nl();
        kenga.setAction(() -> System.out.printf("%s сказал(а) пойти собрать шишек%n", kenga.getName()));
        kenga.makeAction();
        nl();
        Consumer<Animal> goToTrees = (animal) -> System.out.printf("%s отправился(ась) к Шести соснам%n", animal.getName());
        ry.setAction(() -> goToTrees.accept(ry));
        tigra.setAction(() -> goToTrees.accept(tigra));
        makeActions(children);
        nl();
        Cone[] cones = new Cone[2];
        for (int i = 0; i < 2; i++) {
            cones[i] = (Cone) create(new Cone());
        }
        nl();
        ry.setAction(() -> cones[0].hurl(ry, tigra));
        tigra.setAction(() -> cones[1].hurl(tigra, ry));
        makeActions(children);
        nl();
        Consumer<Animal> forgetAll = (animal) ->
                System.out.printf(
                        "%s забыл(а) зачем пришел(а) в лес и оставил(а) корзинку под деревом%n",
                        animal.getName()
                );
        for (AnimalChild child : children) {
            child.setAction(() -> forgetAll.accept(child));
        }
        makeActions(children);
        nl();
        for (AnimalChild child : children) {
            child.isFed();
        }
        nl();
        Consumer<AnimalChild> goHome = (animal) -> {
            System.out.printf("%s отправился(ась) домой%n", animal.getName());
        };
        for (AnimalChild child : children) {
            child.setAction(() -> goHome.accept(child));
        }
        makeActions(children);
        Consumer<AnimalChild> eat = AnimalChild::eat;
        for (AnimalChild child : children) {
            child.setAction(() -> eat.accept(child));
        }
        makeActions(children);
        nl();
        for (AnimalChild child : children) {
            child.isFed();
        }
    }

    public static Object create(Object object) {
        System.out.printf("Создан обьект - %s%n", object.toString());
        return object;
    }

    public static void makeActions(Animal[] animals) {
        for (Animal animal : animals) {
            animal.makeAction();
        }
    }

    public static void nl() {
        System.out.println();
    }
}
