import java.util.*;

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    public boolean canHop() { return canHop; }
    public boolean canSwim() { return canSwim; }
    public String toString() { return species; }
}

interface CheckTrait {
    boolean test(Animal a);
//    String breakIt();
}

interface Updater {
    String updateSpecies(Animal animal);
}

class CheckIfHopper implements CheckTrait {
    public boolean test(Animal animal) {
        return animal.canHop();
    }

    public String breakIt(){
        return null;
    }
}


public class Lambdas1 {

    public static void main(String[] args) {
        List<Animal> animals = createAnimals();
        print(animals, (Animal animal) -> animal.canHop() );
        print(animals, (Animal animal) -> { return animal.canSwim(); });
        print(animals, (a -> {return a.canSwim();}));
        print(animals, a -> a.canHop());
        printUpdatedSpecies( animals, (Animal animal) ->  animal.toString().equals("fish") ? animal.toString() + "FISHfish" :  animal.toString()  );
        Animal animal = new Animal("animal", false, true);
        System.out.println("wantWhetherCanHop");
        boolean wantWhetherCanHop = true;
        print(animals, a -> a.canHop() == wantWhetherCanHop);

    }

    private static List<Animal> createAnimals(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));
        return animals;
    }

    private static void printUpdatedSpecies(List<Animal> animals, Updater updater) {
        for (Animal animal : animals) {
            String updatedSpecies = updater.updateSpecies(animal);
            System.out.print(updatedSpecies + " ");
        }
        System.out.println();
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal))
                System.out.print(animal + " ");
        }
            System.out.println();
    }
}

