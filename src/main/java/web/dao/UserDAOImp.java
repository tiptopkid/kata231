package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;


@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void add(User user) {
        entityManager.persist(user);

    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery(
                        "select user from User user", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.createQuery(
                        "select user from User user where id=:id", User.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = show(id);
        userToUpdate.setFirstName(updatedUser.getFirstName());
        userToUpdate.setCountry(updatedUser.getCountry());
        userToUpdate.setAge(updatedUser.getAge());

    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);

    }

}
