package Pet;

import java.util.LinkedList;
import java.util.List;

public class PetShop {
    private List<Pet> pets = new LinkedList<>();

    public void add(Pet pet) {
        pets.add(pet);
    }

    public void delete(Pet pet) {
        pets.remove(pet);
    }

    public List<Pet> search(String keyWord) {
        List<Pet> result = new LinkedList<>();
        String key = keyWord.toLowerCase();
        for (Pet p : pets) {
            if (p.getName().toLowerCase().contains(key)) {
                result.add(p);
            }
        }

        return result;
    }
}
