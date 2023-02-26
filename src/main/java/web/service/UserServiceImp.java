package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }
    @Transactional(readOnly = true)
    @Override
        public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

}
