package Login;

import java.util.List;


public interface UserDao {
	
	public UserDto getUserById(Integer id);

	public UserDto getUserByUsername(String username);

	public List<UserDto> getAllUsers();

	public void insertUser(UserDto user);

	public void deleteUser(String username);

	public void updateUser(UserDto user);
	
	public UserDto getUserByUserAndPass(String username, String password);

}
