package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserByCarNameAndCarSeries(String name, int series) {
        return entityManager.createQuery("FROM User WHERE userCar.series=:series and userCar.name=:name", User.class)
                .setParameter("series", series)
                .setParameter("name", name)
                .getSingleResult();
    }
}
