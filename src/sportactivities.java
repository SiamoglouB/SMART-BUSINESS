//sportactivities.java
package projectsiamoglou;
public class SportActivities //Περιγραφή Αθλητικής Δραστηριότητας
{
    private String sportact_name; //όνομα δραστηριότητας π.χ. μπάσκετ
    private String sportact_type; //τύπος δραστηριότητας π.χ. τρέξιμο
    private int sportact_duration; //διάρκεια δραστηριότητας
    private String sportact_distance; //απόσταση δραστηριότητας από Ξενοδοχείο
    private String sportact_place; //τοποθεσία δραστηριότητας
    private String sportact_timetable; //ωράριο λειτουργίας αθλητικού χώρου

    public SportActivities(String sportact_name, String sportact_type, int sportact_duration, String sportact_distance, String sportact_place, String sportact_timetable) {
        this.sportact_name = sportact_name;
        this.sportact_type = sportact_type;
        this.sportact_duration = sportact_duration;
        this.sportact_distance = sportact_distance;
        this.sportact_place = sportact_place;
        this.sportact_timetable = sportact_timetable;
    }
    
    public SportActivities()
    {
    }

    @Override
    public String toString() {
        return "SportActivities{" + "sportact_name=" + sportact_name + ", sportact_type=" + sportact_type + ", sportact_duration=" + sportact_duration + ", sportact_distance=" + sportact_distance + ", sportact_place=" + sportact_place + ", sportact_timetable=" + sportact_timetable + '}';
    }

    public String getSportact_name() {
        return sportact_name;
    }

    public void setSportact_name(String sportact_name) {
        this.sportact_name = sportact_name;
    }

    public String getSportact_type() {
        return sportact_type;
    }

    public void setSportact_type(String sportact_type) {
        this.sportact_type = sportact_type;
    }

    public int getSportact_duration() {
        return sportact_duration;
    }

    public void setSportact_duration(int sportact_duration) {
        this.sportact_duration = sportact_duration;
    }

    public String getSportact_distance() {
        return sportact_distance;
    }

    public void setSportact_distance(String sportact_distance) {
        this.sportact_distance = sportact_distance;
    }

    public String getSportact_place() {
        return sportact_place;
    }

    public void setSportact_place(String sportact_place) {
        this.sportact_place = sportact_place;
    }

    public String getSportact_timetable() {
        return sportact_timetable;
    }

    public void setSportact_timetable(String sportact_timetable) {
        this.sportact_timetable = sportact_timetable;
    }
}