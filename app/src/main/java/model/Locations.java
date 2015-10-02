package model;

/**
 * Created by TEJ's on 9/30/2015.
 */
public class Locations {
    private String location_nm;
//    private int city_id,location_id;

    public Locations() {
    }
        public Locations(String location_name, int city_id, int location_id) {
            this.location_nm = location_name;
  //          this.city_id = city_id;
  //          this.location_id= location_id;
        }

    public String getLocation_nm() {return location_nm;}

    public void setLocation_nm(String location_name) {
        this.location_nm = location_name;
    }


    }
