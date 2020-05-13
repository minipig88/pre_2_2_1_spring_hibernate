package hiber.dao.car;

import hiber.model.Car;

public interface CarDAO {
    Car getCarByNS(String name, int series);
}
