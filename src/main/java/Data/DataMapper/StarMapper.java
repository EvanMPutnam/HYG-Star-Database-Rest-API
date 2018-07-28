package Data.DataMapper;

import Data.DataObject.StarOBJ;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StarMapper {

    public static StarOBJ mapStarData(ResultSet resultSet){
        //id,hip,hd,hr,gl,bf,proper,ra,dec,dist,pmra,pmdec,rv,mag,absmag,spect,ci,x,y,z,vx,vy,vz,rarad,decrad,
        //pmrarad,pmdecrad,bayer,flam,con,comp,comp_primary,base,lum,var,var_min,var_max
        StarOBJ starOBJ = new StarOBJ();
        try {
            starOBJ.setId(resultSet.getString(1));
            starOBJ.setHip(resultSet.getString(2));
            starOBJ.setHd(resultSet.getString(3));
            starOBJ.setHr(resultSet.getString(4));
            starOBJ.setGl(resultSet.getString(5));
            starOBJ.setBf(resultSet.getString(6));
            starOBJ.setProper(resultSet.getString(7));
            starOBJ.setRa(resultSet.getString(8));
            starOBJ.setDec(resultSet.getString(9));
            starOBJ.setDist(resultSet.getString(10));
            starOBJ.setPmra(resultSet.getString(11));
            starOBJ.setPmdec(resultSet.getString(12));
            starOBJ.setRv(resultSet.getString(13));
            starOBJ.setMag(resultSet.getString(14));
            starOBJ.setAbsmag(resultSet.getString(15));
            starOBJ.setSpect(resultSet.getString(16));
            starOBJ.setCi(resultSet.getString(17));
            starOBJ.setX(resultSet.getString(18));
            starOBJ.setY(resultSet.getString(19));
            starOBJ.setZ(resultSet.getString(20));
            starOBJ.setVx(resultSet.getString(21));
            starOBJ.setVy(resultSet.getString(22));
            starOBJ.setVz(resultSet.getString(23));
            starOBJ.setRarad(resultSet.getString(24));
            starOBJ.setDecrad(resultSet.getString(25));
            starOBJ.setPmrarad(resultSet.getString(26));
            starOBJ.setPmdecrad(resultSet.getString(27));
            starOBJ.setBayer(resultSet.getString(28));
            starOBJ.setFlam(resultSet.getString(29));
            starOBJ.setCon(resultSet.getString(30));
            starOBJ.setComp(resultSet.getString(31));
            starOBJ.setComp_primary(resultSet.getString(32));
            starOBJ.setBase(resultSet.getString(33));
            starOBJ.setLum(resultSet.getString(34));
            starOBJ.setVar(resultSet.getString(35));
            starOBJ.setVar_min(resultSet.getString(36));
            starOBJ.setVar_max(resultSet.getString(37));

        }catch (SQLException sql){
            System.out.println("WHAT");
            return starOBJ;
        }

        return starOBJ;
    }

}
