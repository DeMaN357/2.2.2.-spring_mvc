package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    @Autowired
    private CarDao carDao;

    @Transactional
    @Override
    public List<Car> getAllCarWhereName(String name) {
        return carDao.getAllCarWhereName(name);
    }
}
