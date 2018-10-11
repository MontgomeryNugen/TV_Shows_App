package tv.business;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import tv.util.DBUtil;

public class ShowDB implements ShowDAO {

	@Override
	public List<Show> get(String genre) {
		String sql = "SELECT * FROM tvshow where genre = ?";
		List<Show> shows = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, genre);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String rating = rs.getString(3);
				int length = rs.getInt(4);
				String g = rs.getString(5);
				String network = rs.getString(6);

				Show s = new Show(id, name, rating, length, g, network);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	@Override
	public List<Show> get(int length) {
		String sql = "SELECT * FROM tvshow where length = ?";
		List<Show> shows = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, length);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String rating = rs.getString(3);
				int l = rs.getInt(4);
				String genre = rs.getString(5);
				String network = rs.getString(6);

				Show s = new Show(id, name, rating, l, genre, network);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	@Override
	public List<Show> getAll() {
		String sql = "SELECT * FROM tvshow";
		List<Show> shows = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String rating = rs.getString(3);
				int length = rs.getInt(4);
				String genre = rs.getString(5);
				String network = rs.getString(6);

				Show s = new Show(id, name, rating, length, genre, network);
				shows.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	@Override
	public boolean add(Show s) {
		String sql = "INSERT INTO tvshow (id, name, rating, length, genre, network)" + 
				"VALUES (?, ?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getRating());
			ps.setInt(4, s.getLength());
			ps.setString(5, s.getGenre());
			ps.setString(6, s.getNetwork());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Show s) {
		System.out.println("Not yet implemented.");
		return false;
	}

	@Override
	public boolean delete(int id) {
		String sql = "DELETE FROM tvshow WHERE id = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql)){
			ps.setInt(1, s.getId());
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
