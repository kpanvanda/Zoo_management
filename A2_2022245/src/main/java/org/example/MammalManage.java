package org.example;

import java.util.ArrayList;
import java.util.List;

public class MammalManage implements AnimalManage {
    private List<Animal> mammals = new ArrayList<>();

    @Override
    public void addAnimal(String name, String type , String sound) {
        Animal animal = new Animal(name, type , sound);
        mammals.add(animal);
    }

    @Override
    public boolean updateAnimal(String name, String type, String updatedName, String updatedType, String updatedSound) {
        for (Animal animal : mammals) {
            if (animal.name.equalsIgnoreCase(name) && animal.type.equalsIgnoreCase(type)) {
                animal.name = updatedName;
                animal.type = updatedType;
                animal.sound = updatedSound;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAnimal(String name) {
        for (Animal animal : mammals) {
            if (animal.name.equalsIgnoreCase(name)) {
                mammals.remove(animal);
                return true;
            }
        }
        return false;
    }
}
