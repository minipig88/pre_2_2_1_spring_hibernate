package hiber.dao.car;

import hiber.model.Car;
import org.hibernate.SessionFactory;

public interface CarDAO {
    Car getCarByNS(String name, int series);
}
