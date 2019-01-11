package com.homemanagement.pojo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

/**
 * @author rr
 *
 */
@Component
@XmlRootElement
public class SampleUnit {

    private String owner;
    private String rooms;
    private String type;
    private List<SampleUnit> listOfUnits;
    private List<SampleClass> listofClass;

    /**
     *
     */
    public SampleUnit() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param owner
     * @param rooms
     * @param type
     * @param listOfUnits
     * @param listofClass
     */
    public SampleUnit(String owner, String rooms, String type, List<SampleUnit> listOfUnits,
            List<SampleClass> listofClass) {
        super();
        this.owner = owner;
        this.rooms = rooms;
        this.type = type;
        this.listOfUnits = listOfUnits;
        this.listofClass = listofClass;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the rooms
     */
    public String getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the listOfUnits
     */
    public List<SampleUnit> getListOfUnits() {
        return listOfUnits;
    }

    /**
     * @param listOfUnits the listOfUnits to set
     */
    public void setListOfUnits(List<SampleUnit> listOfUnits) {
        this.listOfUnits = listOfUnits;
    }

    /**
     * @return the listofClass
     */
    public List<SampleClass> getListofClass() {
        return listofClass;
    }

    /**
     * @param listofClass the listofClass to set
     */
    public void setListofClass(List<SampleClass> listofClass) {
        this.listofClass = listofClass;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SampleUnit [owner=" + owner + ", rooms=" + rooms + ", type=" + type + ", listOfUnits=" + listOfUnits
                + ", listofClass=" + listofClass + "]";
    }

}
