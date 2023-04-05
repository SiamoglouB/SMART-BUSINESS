//ArtHistory.java
package projectsiamoglou;
public class ArtHistory //Περιγραφή Αρχαιολογικού Χώρου ως Αξιοθέατο
{
    private String arthist_name; //όνομα δραστηριότητας π.χ. επίσκεψη σε Μουσείο
    private String arthist_type; //είδος π.χ. επίσκεψη, περίπατος, ξενάγηση
    private double arthist_distance; //απόσταση αρχαιολογικού χώρου από ξενοδοχείο
    private String arthist_place; //τοποθεσία αρχαιολογικού χώρου
    private String arthist_timetable; //Ωράριο λειτουργίας αρχαιολογικού χώρου
    private double arthist_cost; //Κόστος επίσκεψης αρχαιολογικού χώρου

   
    public ArtHistory(String arthist_name, String arthist_type, double arthist_distance, String arthist_place, String arthist_timetable, double arthist_cost) {
        this.arthist_name = arthist_name;
        this.arthist_type = arthist_type;
        this.arthist_distance = arthist_distance;
        this.arthist_place = arthist_place;
        this.arthist_timetable = arthist_timetable;
        this.arthist_cost = arthist_cost;
    }
    
    public ArtHistory()
    {
        
    }

    public String getArthist_name() {
        return arthist_name;
    }

    public void setArthist_name(String arthist_name) {
        this.arthist_name = arthist_name;
    }

    public String getArthist_type() {
        return arthist_type;
    }

    public void setArthist_type(String arthist_type) {
        this.arthist_type = arthist_type;
    }

    public double getArthist_distance() {
        return arthist_distance;
    }

    public void setArthist_distance(double arthist_distance) {
        this.arthist_distance = arthist_distance;
    }

    public String getArthist_place() {
        return arthist_place;
    }

    public void setArthist_place(String arthist_place) {
        this.arthist_place = arthist_place;
    }

    public String getArthist_timetable() {
        return arthist_timetable;
    }

    public void setArthist_timetable(String arthist_timetable) {
        this.arthist_timetable = arthist_timetable;
    }

    public double getArthist_cost() {
        return arthist_cost;
    }

    public void setArthist_cost(double arthist_cost) {
        this.arthist_cost = arthist_cost;
    }
    
    @Override
    public String toString() {
        return "ArtHistory{" + "arthist_name=" + arthist_name + ", arthist_type=" + arthist_type + ", arthist_distance=" + arthist_distance + ", arthist_place=" + arthist_place + ", arthist_timetable=" + arthist_timetable + ", arthist_cost=" + arthist_cost + '}';
    }
}