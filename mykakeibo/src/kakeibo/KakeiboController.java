package kakeibo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KakeiboController {

	// Create instance
	private static KakeiboController controller = new KakeiboController();

	// Constractor
    public static KakeiboController getInstance() {
    	return controller;
    }

private KakeiboController() {
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
			+ "pr_cost)" + " VALUES('" + topic.getPrname() + "','"
			+ topic.getGenre() + "','" + Integer.valueOf(topic.getPrcost()) + "')";

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

//固定費のアップデート
public void postFixed(Topic topic) {

 String sql = "INSERT INTO m_fixed (fx_name, fx_cost)"
               + " VALUES('" + topic.getFxName()
               + "'," + Integer.valueOf(topic.getFxCost()) + ")";

 Connection con = null;
 Statement smt = null;
 try{
     con = ConnectionManager.getConnection();
     smt = con.createStatement();
     smt.executeUpdate(sql);
 } catch (SQLException e){
     e.printStackTrace();
 } finally {
     if (smt != null) {
         try {
             smt.close();
         } catch (Exception ignore){
         }
     }
     if (con != null) {
         try {
             con.close();
         } catch (Exception ignore){
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

	// 固定費の取得
	public List<Topic> getFixed(){

	    String sql = "SELECT fx_name, fx_cost FROM m_fixed";
	    List<Topic> topics = new ArrayList<Topic>();

	    Connection con = null;
	    Statement smt = null;
	    ResultSet rs = null;
	    try {
	        con = ConnectionManager.getConnection();
	        smt = con.createStatement();
	        rs = smt.executeQuery(sql);
	        while (rs.next()){
	            Topic topic = new Topic();
	            topic.setFxName(rs.getString("fx_name"));
	            topic.setFxCost(rs.getString("fx_cost"));
	            topics.add(topic);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (Exception ignore) {
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
	            } catch (Exception ignore){
	            }
	        }
	        }
	        return topics;
	    }

	//固定費の合計
	public Topic getTotalFxCost(){
	    String sql = "SELECT SUM(fx_cost) as totalFxCost"
	                + " FROM m_fixed";
	    Topic totalFxCost = new Topic();

	    Connection con = null;
	    Statement smt = null;
	    ResultSet rs = null;
	    try {
	        con = ConnectionManager.getConnection();
	        smt = con.createStatement();
	        rs = smt.executeQuery(sql);
	        //totalFxCostを取得
	        while (rs.next()){
	            if (rs.getString("totalFxCost") != null){
	                totalFxCost.setTotalFxCost(rs.getString("totalFxCost"));
	            } else {
	                continue;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {
	            try {
	                rs.close();
	            } catch (Exception ignore){
	            }
	        }
	        if(smt != null) {
	            try {
	                smt.close();
	            } catch (Exception ignore){
	            }
	        }
	        if (con != null) {
	            try{
	                con.close();
	            } catch (Exception ignore){
	            }
	        }
	        }
	        return totalFxCost;
	    }


// DBからデータ取得：出費合計(Variable)
	public Topic getMsTotalVariableCost(){
		String sql = "SELECT SUM(pr_cost) as totalVariableCost"
				    + " FROM trade_log"
				   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))";
//		System.out.println(sql);
		Topic totalVariableCost = new Topic();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			//totalVariableCostを取得
			while (rs.next()) {
				if (rs.getString("totalVariableCost") != null){
					totalVariableCost.setTotalVariableCost(rs.getString("totalVariableCost"));
				} else {
					continue;
				}
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
				    smt.close();
			    } catch (Exception ignore) {
			    }
		    }
		    if (con != null) {
		    	try {
		    	con.close();
		        } catch (Exception ignore) {
		        }
		    }
		    }
		    return totalVariableCost;
	}



	// DBからデータ取得：月別食費合計
		public Topic getMsMonthlyFoodCost(){
			String sql = "SELECT SUM(pr_cost) as monthlyFoodCost"
					    + " FROM trade_log"
					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
					   + " AND genre = 'Food'";
			Topic monthlyFoodCost = new Topic();

			Connection con = null;
			Statement smt = null;
			ResultSet rs = null;

			try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
				rs = smt.executeQuery(sql);
				//totalVariableCostを取得
				while (rs.next()) {
					if (rs.getString("monthlyFoodCost") != null) {
						monthlyFoodCost.setMonthlyFoodCost(rs.getString("monthlyFoodCost"));
					} else {
						continue;
					}
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
						smt.close();
					} catch (Exception ignore) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception ignore) {
					}
				}
			    }
				return monthlyFoodCost;
		}

		// DBからデータ取得：月別書籍費合計
		public Topic getMsMonthlyBookCost(){
			String sql = "SELECT SUM(pr_cost) as monthlyBookCost"
					    + " FROM trade_log"
					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
					   + " AND genre = 'Book'";
			Topic monthlyBookCost = new Topic();

			Connection con = null;
			Statement smt = null;
			ResultSet rs = null;

			try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
				rs = smt.executeQuery(sql);
				//totalVariableCostを取得
				while (rs.next()){
					if (rs.getString("monthlyBookCost") != null) {
						monthlyBookCost.setMonthlyBookCost(rs.getString("monthlyBookCost"));
					} else {
						continue;
					}
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
						smt.close();
					} catch (Exception ignore) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception ignore) {
					}
				}
			    }
				return monthlyBookCost;
		}

		// DBからデータ取得：月別光熱費合計
		public Topic getMsMonthlyUtilityCost(){
			String sql = "SELECT SUM(pr_cost) as monthlyUtilityCost"
					    + " FROM trade_log"
					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
					   + " AND genre = 'Utility Cost'";
			Topic monthlyUtilityCost = new Topic();
			Connection con = null;
			Statement smt = null;
			ResultSet rs = null;

			try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
				rs = smt.executeQuery(sql);
				//totalVariableCostを取得
				while (rs.next()) {
					if (rs.getString("monthlyUtilityCost") != null) {
						monthlyUtilityCost.setMonthlyUtilityCost(rs.getString("monthlyUtilityCost"));
					} else {
						continue;
					}
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
						smt.close();
					} catch (Exception ignore) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception ignore) {
					}
				}
			    }
				return monthlyUtilityCost;
		}

		// DBからデータ取得：月別その他費用合計
		public Topic getMsMonthlyElseCost(){
			String sql = "SELECT SUM(pr_cost) as monthlyElseCost"
					    + " FROM trade_log"
					   + " WHERE (DATE_FORMAT(pdate, '%Y%M') = (DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y%M')))"
					   + " AND genre = 'Else'";
			Topic monthlyElseCost = new Topic();


			Connection con = null;
			Statement smt = null;
			ResultSet rs = null;

			try {
				con = ConnectionManager.getConnection();
				smt = con.createStatement();
				rs = smt.executeQuery(sql);
				//totalVariableCostを取得
				while (rs.next()) {
					if (rs.getString("monthlyElseCost") != null) {
						monthlyElseCost.setMonthlyElseCost(rs.getString("monthlyElseCost"));
					}
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
						smt.close();
					} catch (Exception ignore) {
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (Exception ignore) {
					}
				}
			    }
				return monthlyElseCost;
		}



	public static void main(String[] args) {
//		KakeiboController ctrl = KakeiboController.getInstance();
//		Topic variable = ctrl.getMsTotalVariableCost();
//		Topic Food = ctrl.getMsMonthlyFoodCost();
//		Topic Book = ctrl.getMsMonthlyBookCost();
//		Topic Utility = ctrl.getMsMonthlyUtilityCost();
//		Topic Else = ctrl.getMsMonthlyElseCost();
//
//		System.out.println(variable.getTotalVariableCost());
//		System.out.println(Food.getMonthlyFoodCost());
//		System.out.println(Book.getMonthlyBookCost());
//		System.out.println(Utility.getMonthlyUtilityCost());
//		System.out.println(Else.getMonthlyElseCost());

		KakeiboController ctrl = KakeiboController.getInstance();
		List<Topic> fixed = ctrl.getFixed();
		for (int i=0; i < fixed.size();i++) {
			Topic fix = fixed.get(i);
			System.out.println(fix);
			System.out.println(i);
		}


//		for (int i=0; i < topics.size(); i++) {
//			System.out.println(topics.get(i));
//		}

		System.out.println("END");
	}
}





