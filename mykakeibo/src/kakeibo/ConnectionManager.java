package kakeibo; // Closed

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * シンプルなコネクション管理クラス
 * @author shoheitokumaru
 *
 **/
public class ConnectionManager {

	/**
	 * JDBCドライバのクラス名
	 */
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	/**
	 * データベースのURL
	 */
	final static String URL = "jdbc:mysql://localhost/kakeibo";

	/**
	 * データベースのユーザー
	 */
	final static String USER = "root";

	/**
	 * データベースのパスワード
	 */
	final static String PASS = "a2469tkmr";

	/**
	 * Connectionを取得
	 * →DBと繋げる儀式的なやつ
	 */

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(DRIVER); // 行いたい処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	//例外処理
			throw new IllegalStateException(
					"fail to class load : "
			+ e.getMessage());

		}
		Connection con = DriverManager.getConnection(URL, USER, PASS);

		return con;
	}
}


/**
 *
 *
 *
 *
 *
 *
 *
*/
