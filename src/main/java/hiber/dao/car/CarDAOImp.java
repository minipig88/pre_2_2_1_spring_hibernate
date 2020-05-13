package hiber.dao.car;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CarDAOImp implements CarDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Car getCarByNS(String name, int series) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Car WHERE name=:paramName AND series=:paramSeries");
        query.setParameter("paramName", name);
        query.setParameter("paramSeries", series);
        return (Car) query.uniqueResult();
    }
}
