/**
 * Created by brian on 3/5/16.
 */


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;


public class MilitaryAirplane implements Serializable
{
    private String airplaneName;
    private String airplaneType;
    private String airplaneDesignation;
    private String airplaneManufacturer;
    private String role;
    private String militaryArmAssigned;

    MilitaryAirplane(String airplaneName, String airplaneType, String airplaneDesignation, String airplaneManufacturer,
                     String role, String militaryArmAssigned)
    {
        this.airplaneName         = airplaneName;
        this.airplaneType         = airplaneType;
        this.airplaneDesignation  = airplaneDesignation;
        this.airplaneManufacturer = airplaneManufacturer;
        this.role                 = role;
        this.militaryArmAssigned  = militaryArmAssigned;
    }

    public MilitaryAirplane(HashMap militaryAirplaneHashMap)
    {
        this.airplaneName         = (String)militaryAirplaneHashMap.get("airplaneName");
        this.airplaneType         = (String)militaryAirplaneHashMap.get("airplaneType");
        this.airplaneDesignation  = (String)militaryAirplaneHashMap.get("airplaneDesignation");
        this.airplaneManufacturer = (String)militaryAirplaneHashMap.get("airplaneManufacturer");
        this.role                 = (String)militaryAirplaneHashMap.get("role");
        this.militaryArmAssigned  = (String)militaryAirplaneHashMap.get("militaryArmAssigned");
    }

    public String getAirplaneName()
    {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName)
    {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneType()
    {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType)
    {
        this.airplaneType = airplaneType;
    }

    public String getAirplaneDesignation()
    {
        return airplaneDesignation;
    }

    public void setAirplaneDesignation(String airplaneDesignation)
    {
        this.airplaneDesignation = airplaneDesignation;
    }

    public String getAirplaneManufacturer()
    {
        return airplaneManufacturer;
    }

    public void setAirplaneManufacturer(String airplaneManufacturer)
    {
        this.airplaneManufacturer = airplaneManufacturer;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public String getMilitaryArmAssigned()
    {
        return militaryArmAssigned;
    }

    public void setMilitaryArmAssigned(String militaryArmAssigned)
    {
        this.militaryArmAssigned = militaryArmAssigned;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MilitaryAirplane that = (MilitaryAirplane) o;

        if (!airplaneName.equals(that.airplaneName)) return false;
        if (!airplaneType.equals(that.airplaneType)) return false;
        if (!airplaneDesignation.equals(that.airplaneDesignation)) return false;
        if (!airplaneManufacturer.equals(that.airplaneManufacturer)) return false;
        if (!role.equals(that.role)) return false;
        return militaryArmAssigned.equals(that.militaryArmAssigned);
    }

    @Override
    public int hashCode()
    {
        int result = airplaneName.hashCode();
        result = 31 * result + airplaneType.hashCode();
        result = 31 * result + airplaneDesignation.hashCode();
        result = 31 * result + airplaneManufacturer.hashCode();
        result = 31 * result + role.hashCode();
        result = 31 * result + militaryArmAssigned.hashCode();
        return result;
    }
}
