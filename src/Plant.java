
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author csmoak2016
 */
public class Plant{
    
    private String name;
    private String plantType;
    private int waterInterval;

    Plant(String name, String plantType, int waterInterval) {
        this.name = name;
        this.plantType = plantType;
        this.waterInterval = waterInterval;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPlantType(){
        return this.plantType;
    }
    
    public int getWaterInterval(){
        return this.waterInterval;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPlantType(String type){
        this.plantType = type;
    }
    
    public void setWaterInterval(int interval){
        this.waterInterval = interval;
    }
    
    public void setNull(){
        this.name = null;
        this.plantType = null;
    }
    
    public void setEqual(Plant copy){
        this.name = copy.getName();
        this.plantType = copy.getPlantType();
        this.waterInterval = copy.getWaterInterval();
    }
}
