package web_gradle_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web_gradle_erp.dao.TitleDao;
import web_gradle_erp.dto.Title;

public class TitleDaoImpl implements TitleDao {
	private static final TitleDaoImpl instance = new TitleDaoImpl();
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}

	public static TitleDaoImpl getInstance() {
		return instance;
	}

	private TitleDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Title> selectTitleByAll() {
		String sql = "select tno, tname from title";

		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				List<Title> list = new ArrayList<Title>();
				do {
					list.add(getTitle(rs));
				} while (rs.next());
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private Title getTitle(ResultSet rs) throws SQLException {
		// tNo, tName
		int tNo = rs.getInt("tno");
		String tName = rs.getString("tname");
		return new Title(tNo, tName);
	}

	@Override
	public Title selectTitleByNo(Title title) {
		String sql = "select tno, tname from title where tno = ? ";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, title.gettNo());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getTitle(rs);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertTitle(Title title) {
		return 0;
	}

	@Override
	public int updateTitle(Title title) {
		return 0;
	}

	@Override
	public int deleteTitle(Title title) {
		return 0;
	}

}
