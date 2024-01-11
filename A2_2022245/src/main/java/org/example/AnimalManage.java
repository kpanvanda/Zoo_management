package org.example;

interface AnimalManage {
    void addAnimal(String name, String type , String sound );
    boolean updateAnimal(String name, String type, String updatedName, String updatedType, String updatedSound);
    boolean removeAnimal(String name);

}
