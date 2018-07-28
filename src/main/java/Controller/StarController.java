package Controller;


import Data.DAO.StarDAO;
import Data.DataObject.StarOBJ;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


/**
 * http://localhost:8080/x?x1=12&x2=45
 * Example of query with optional params
 */

@RestController
public class StarController {

    @RequestMapping("/id")
    public StarOBJ starObjByID(@RequestParam(value = "id", defaultValue = "1") String id){
        return new StarDAO().getByID(id);
    }

    @RequestMapping("/name")
    public StarOBJ starObjByProperName(@RequestParam(value = "name", defaultValue = "Sol") String name){
        return new StarDAO().getByProperName(name);
    }

    @RequestMapping("/x")
    public ArrayList<StarOBJ> starObjByXVals(@RequestParam(value = "x1", defaultValue = "0") String x,
                                             @RequestParam(value = "x2", defaultValue = "10") String x2){
        return new StarDAO().getStarsByX(x, x2);
    }

    @RequestMapping("/y")
    public ArrayList<StarOBJ> starObjByYVals(@RequestParam(value = "y1", defaultValue = "0") String y,
                                             @RequestParam(value = "y2", defaultValue = "10") String y2){
        return new StarDAO().getStarsByY(y, y2);
    }

    @RequestMapping("/z")
    public ArrayList<StarOBJ> starObjByZVals(@RequestParam(value = "z1", defaultValue = "0") String z,
                                             @RequestParam(value = "z2", defaultValue = "10") String z2){
        return new StarDAO().getStarsByZ(z, z2);
    }

    @RequestMapping("/xyz")
    public ArrayList<StarOBJ> starObjByXYZVals(@RequestParam(value = "x1", defaultValue = "0") String x,
                                               @RequestParam(value = "x2", defaultValue = "100") String x2,
                                               @RequestParam(value = "y1", defaultValue = "0") String y,
                                               @RequestParam(value = "y2", defaultValue = "100") String y2,
                                               @RequestParam(value = "z1", defaultValue = "0") String z,
                                               @RequestParam(value = "z2", defaultValue = "100") String z2){
        return new StarDAO().getStarsByXYZ(x, x2, y, y2, z, z2);
    }






}
