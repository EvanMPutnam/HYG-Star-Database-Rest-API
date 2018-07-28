package Data.DAO;

import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface IStarDAO {

    public static final String DB_NAME = "stars.db";

    public static final String QUERY_BY_ID = "SELECT * FROM stars WHERE id = ?";

    public static final String QUERY_BY_PROPER = "SELECT * FROM stars WHERE proper = ?";


    public static final String QUERY_BETWEEN_X  = "SELECT * FROM stars WHERE x > ? AND x < ?";
    public static final String QUERY_BETWEEN_Y = "SELECT * FROM stars WHERE y > ? AND y < ?";
    public static final String QUERY_BETWEEN_Z = "SELECT * FROM stars WHERE z > ? AND z < ?";
    public static final String QUERY_BETWEEN_ALL_XYZ = "SELECT * FROM stars WHERE x > ? AND x < ? AND " +
            "y > ? AND y < ? AND z > ? AND z < ?";



}
