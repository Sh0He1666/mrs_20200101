package kakeibo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KakeiboController2 {

	// Create instance
	private static KakeiboController2 controller = new KakeiboController2();

	// Constractor
    public static KakeiboController2 getInstance() {
    	return controller;
    }

private KakeiboController2() {
}

/**
 * トピックをポスト（登録）します。
 *
 * @param topic
 * 　　　　　　　トピック
 */
// DBに対してINSERTするメソッド
public void postTopic(Topic topic) {//Topic.java のインスタンスの作成
	// DB定義書を作ってから
	String sql = "INSERT INTO trade_log(pr_name, genre,"
			+ "pr_cost)" + " VALUES('" + topic.getPrname() + "',"
			+ topic.getGenre() + "," + Integer.valueOf(topic.getPrcost()) + ")";

	Connection con = null;
	Statement smt = null;
	try {
		con = ConnectionManager.getConnection();
		smt = con.createStatement();
		smt.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (smt != null) {
			try {
				smt.close();
			}catch(Exception ignore) {
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch(Exception ignore) {
			}
		}
	}
}

/**
* 最近の（というか全部の）トピックを取得する
*
* @return トピックのリスト
*/
// DBからデータを取得するメソッド
	public List<Topic> getTopics(){

		String sql = "SELECT FROM trade_log";
		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setGenre(rs.getString("genre"));
				topic.setPrname(rs.getString("pr_name"));
				topic.setPrcost(rs.getString("pr_cost"));
				topic.setPdate(rs.getDate("pdate"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(Exception ignore) {
				}
			}
		if (smt != null) {
			try {
				smt.close();
			} catch (Exception ignore){
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception ignore) {
			}
		}
		}

		return topics;
	}


// DBからデータ取得：出費合計(Variable)
	public List<Topic> getVariableCosts(){
		String[] sql = new String[4];
		sql[0] = "SELECT SUM(pr_cost) as totalVariableCost"
			    + " FROM trade_log"
			   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))";
		sql[1] = "SELECT SUM(pr_cost) as monthlyFoodCost"
			    + " FROM trade_log"
			   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
			   + " AND genre = 'Food'";
		sql[2] = "SELECT SUM(pr_cost) as monthlyFoodCost"
			    + " FROM trade_log"
			   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
			   + " AND genre = 'Book'";
		sql[3] = "SELECT SUM(pr_cost) as monthlyFoodCost"
			    + " FROM trade_log"
			   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
			   + " AND genre = 'Utility Cost'";
		sql[4] = "SELECT SUM(pr_cost) as monthlyFoodCost"
			    + " FROM trade_log"
			   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
			   + " AND genre = 'Else'";

		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			//totalVariableCostを取得
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setTotalVariableCost(rs.getInt("totalVariableCost"));
				topics.add(topic);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				 } catch (Exception ignore) {
				 }
			}
		if (smt != null) {
			try {
				con.close();
			} catch (Exception igonre) {
			}
		}
		}
		return topics;
	}


//	// DBからデータ取得：月別食費合計
//		public List<Topic> getMsMonthlyFoodCost(){
//			String sql = "SELECT SUM(pr_cost) as monthlyFoodCost"
//					    + " FROM trade_log"
//					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
//					   + " AND genre = 'Food'";
//			List<Topic> topics = new ArrayList<Topic>();
//
//			Connection con = null;
//			Statement smt = null;
//			ResultSet rs = null;
//
//			try {
//				con = ConnectionManager.getConnection();
//				smt = con.createStatement();
//				rs = smt.executeQuery(sql);
//				//totalVariableCostを取得
//				while (rs.next()) {
//					Topic topic = new Topic();
//					topic.setMonthlyFoodCost(rs.getInt("monthlyFoodCost"));
//					topics.add(topic);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				if(rs != null) {
//					try {
//						rs.close();
//					 } catch (Exception ignore) {
//					 }
//				}
//			if (smt != null) {
//				try {
//					con.close();
//				} catch (Exception igonre) {
//				}
//			}
//			}
//			return topics;
//		}
//
//		// DBからデータ取得：月別書籍費合計
//		public List<Topic> getMsMonthlyBookCost(){
//			String sql = "SELECT SUM(pr_cost) as monthlyBookCost"
//					    + " FROM trade_log"
//					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
//					   + " AND genre = 'Book'";
//			List<Topic> topics = new ArrayList<Topic>();
//
//			Connection con = null;
//			Statement smt = null;
//			ResultSet rs = null;
//
//			try {
//				con = ConnectionManager.getConnection();
//				smt = con.createStatement();
//				rs = smt.executeQuery(sql);
//				//totalVariableCostを取得
//				while (rs.next()){
//					Topic topic = new Topic();
//					topic.setMonthlyBookCost(rs.getInt("monthlyBookCost"));
//					topics.add(topic);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				if(rs != null) {
//					try {
//						rs.close();
//					 } catch (Exception ignore) {
//					 }
//				}
//			if (smt != null) {
//				try {
//					con.close();
//				} catch (Exception igonre) {
//				}
//			}
//			}
//			return topics;
//		}
//
//		// DBからデータ取得：月別光熱費合計
//		public List<Topic> getMsMonthlyUtilityCost(){
//			String sql = "SELECT SUM(pr_cost) as monthlyUtilityCost"
//					    + " FROM trade_log"
//					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
//					   + " AND genre = 'Utility Cost'";
//			List<Topic> topics = new ArrayList<Topic>();
//			Connection con = null;
//			Statement smt = null;
//			ResultSet rs = null;
//
//			try {
//				con = ConnectionManager.getConnection();
//				smt = con.createStatement();
//				rs = smt.executeQuery(sql);
//				//totalVariableCostを取得
//				while (rs.next()) {
//					Topic topic = new Topic();
//					topic.setMonthlyUtilityCost(rs.getInt("monthlyUtilityCost"));
//					topics.add(topic);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				if(rs != null) {
//					try {
//						rs.close();
//					 } catch (Exception ignore) {
//					 }
//				}
//			if (smt != null) {
//				try {
//					con.close();
//				} catch (Exception igonre) {
//				}
//			}
//			}
//			return topics;
//		}
//
//		// DBからデータ取得：月別その他費用合計
//		public List<Topic> getMsMonthlyElseCost(){
//			String sql = "SELECT SUM(pr_cost) as monthlyElseCost"
//					    + " FROM trade_log"
//					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
//					   + " AND genre = 'Else'";
//			List<Topic> topics = new ArrayList<Topic>();
//
//
//			Connection con = null;
//			Statement smt = null;
//			ResultSet rs = null;
//
//			try {
//				con = ConnectionManager.getConnection();
//				smt = con.createStatement();
//				rs = smt.executeQuery(sql);
//				//totalVariableCostを取得
//				while (rs.next()) {
//					Topic topic = new Topic();
//					topic.setMonthlyElseCost(rs.getInt("monthlyElseCost"));
//					topics.add(topic);
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				if(rs != null) {
//					try {
//						rs.close();
//					 } catch (Exception ignore) {
//					 }
//				}
//			if (smt != null) {
//				try {
//					con.close();
//				} catch (Exception igonre) {
//				}
//			}
//			}
//			return topics;
//		}



	public static void main(String[] args) {
		KakeiboController2 ctrl = KakeiboController2.getInstance();
		List <Topic> variable = ctrl.getMsTotalVariableCost();
		List <Topic> Food = ctrl.getMsMonthlyFoodCost();
		List <Topic> Book = ctrl.getMsMonthlyBookCost();
		List <Topic> Utility = ctrl.getMsMonthlyUtilityCost();
		List <Topic> Else = ctrl.getMsMonthlyElseCost();

		for (int i = 0; i < variable.size(); i++) {
			System.out.println(variable.get(i));
			Topic topic = variable.get(i);
			System.out.println(topic.getTotalVariableCost());
		}
		System.out.println();


//		for (int i=0; i < topics.size(); i++) {
//			System.out.println(topics.get(i));
//		}

		System.out.println("END");
	}
}





