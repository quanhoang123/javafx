package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class UserDaoImpl implements UserDao {

	@Override
	public UserDto getUserById(Integer id) {

		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE ID = '" + id + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserDto getUserByUsername(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE USERNAME = '" + username + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
			List<UserDto> users = new ArrayList<>();
			while (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				users.add(userDto);
			}
			return users;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionFactory.getConnection();

			String queryString = "INSERT INTO USER VALUE(NULL, ?, ?, ?, ?, ?)";
			ps = connection.prepareStatement(queryString);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setDate(3, user.getBirthday());
			ps.setString(4, user.getPhoneNumber());
			ps.setString(5, user.getAddress());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void deleteUser(String username) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate("DELETE FROM USER WHERE USERNAME = '" + username + "'");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void updateUser(UserDto user) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = ConnectionFactory.getConnection();
			String queryString = "UPDATE USER SET BIRTHDAY = ?, PHONE_NUMBER = ?, ADDRESS = ? WHERE ID = ?";
			ps = connection.prepareStatement(queryString);
			ps.setDate(1, user.getBirthday());
			ps.setString(2, user.getPhoneNumber());
			ps.setString(3, user.getAddress());
			ps.setInt(4, user.getId());

			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public UserDto getUserByUserAndPass(String username, String password) {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER WHERE USERNAME = '" + username + "'" + " AND PASSWORD = '" + password + "'");
			if (rs.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(rs.getInt("ID"));
				userDto.setUsername(rs.getString("USERNAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setBirthday(rs.getDate("BIRTHDAY"));
				userDto.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				userDto.setAddress(rs.getString("ADDRESS"));

				return userDto;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
