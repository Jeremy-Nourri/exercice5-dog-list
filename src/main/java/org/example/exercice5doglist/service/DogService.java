package org.example.exercice5doglist.service;

import org.example.exercice5doglist.model.Dog;

import java.util.List;

public class DogService extends BaseService {

    public boolean create(Dog dog) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(dog);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Dog findById(int id) {
        session = sessionFactory.openSession();
        Dog dog = session.get(Dog.class, id);
        session.close();
        return dog;
    }

    public List<Dog> findAll() {
        session = sessionFactory.openSession();
        List<Dog> dogList = session.createQuery("from Dog").list();
        session.close();
        return dogList;
    }
}
