package Login;


public class UserManagementImpl implements IUserManagement {

	UserDao userDao = new UserDaoImpl();
	
	@Override
	public boolean checkLogin(String username, String password) {
		UserDto userDto = userDao.getUserByUserAndPass(username, password);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}
	}

}
