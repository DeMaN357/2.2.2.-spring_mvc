package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;

@Repository
public class CarDaoImplementation implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Car> getAllCarWhereName(String name) {
        return sessionFactory.openSession().createQuery("select car from Car car where car.name =: name", Car.class).setParameter("name", name).getResultList();
    }
}
