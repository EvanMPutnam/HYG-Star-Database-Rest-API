package Data.DAO;

import Data.DataMapper.StarMapper;
import Data.DataObject.StarOBJ;

import java.sql.*;
import java.util.ArrayList;

public class StarDAO implements IStarDAO{

    private Connection connectToDatabase(){
        Connection connection = null;
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            String url = "jdbc:sqlite:"+classLoader.getResource(DB_NAME).getPath();
            connection = DriverManager.getConnection(url);
        }catch (SQLException e){
            return null;
        }
        return connection;
    }


    private StarOBJ getStarDataSingle(ArrayList<String> params, String query){

        StarOBJ starOBJ = new StarOBJ();
        Connection connection = connectToDatabase();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int count = 1;
            for (String s:params) {
                preparedStatement.setString(count, s);
                count += 1;
            }
            ResultSet rs = preparedStatement.executeQuery();
            return StarMapper.mapStarData(rs);
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return starOBJ;
    }

    private ArrayList<StarOBJ> getStarDataMultiple(ArrayList<String> params, String query){
        Connection connection = connectToDatabase();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int count = 1;
            for (String s:params) {
                preparedStatement.setString(count, s);
                count += 1;
            }

            ArrayList<StarOBJ> starOBJS = new ArrayList<>();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                starOBJS.add(StarMapper.mapStarData(rs));
            }
            return starOBJS;

        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }





    //TODO get x,y,z,ra,dec,alt,az
    public StarOBJ getByID(String id){
        ArrayList<String> params = new ArrayList<>();
        params.add(id);
        return getStarDataSingle(params, QUERY_BY_ID);
    }

    public StarOBJ getByProperName(String name){
        ArrayList<String> params = new ArrayList<>();
        params.add(name);
        return getStarDataSingle(params, QUERY_BY_PROPER);
    }

    public ArrayList<StarOBJ> getStarsByX(String x1, String x2){
        ArrayList<String> params = new ArrayList<>();
        params.add(x1);
        params.add(x2);
        return getStarDataMultiple(params, QUERY_BETWEEN_X);
    }

    public ArrayList<StarOBJ> getStarsByY(String y1, String y2){
        ArrayList<String> params = new ArrayList<>();
        params.add(y1);
        params.add(y2);
        return getStarDataMultiple(params, QUERY_BETWEEN_Y);
    }

    public ArrayList<StarOBJ> getStarsByZ(String z1, String z2){
        ArrayList<String> params = new ArrayList<>();
        params.add(z1);
        params.add(z2);
        return getStarDataMultiple(params, QUERY_BETWEEN_Z);
    }

    public ArrayList<StarOBJ> getStarsByXYZ(String x1, String x2, String y1, String y2, String z1, String z2){
        ArrayList<String> params = new ArrayList<>();
        params.add(x1);
        params.add(x2);
        params.add(y1);
        params.add(y2);
        params.add(z1);
        params.add(z2);
        return getStarDataMultiple(params, QUERY_BETWEEN_ALL_XYZ);
    }







}
