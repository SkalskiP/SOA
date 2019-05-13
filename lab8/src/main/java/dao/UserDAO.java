package dao;

import dto.UserDTO;

public class UserDAO extends AbstractDAO<UserDTO> {
    private UserDAO() {
        super(UserDTO.class);
    }

    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }
}

