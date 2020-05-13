package hiber.dao.car;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;


@Repository
public class CarDAOImp implements CarDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarByNS(String name, int series) {
        TypedQuery<Car> query = sessionFactory.getCurrentSession().createQuery("FROM Car WHERE name=:paramName AND series=:paramSeries");
        query.setParameter("paramName", name);
        query.setParameter("paramSeries", series);
        return query.getSingleResult();
    }
}
