//FoodDrink.java
package projectsiamoglou;

import java.util.Date;

public class FoodDrink //Περιγραφή δραστηριότητας εστίασης
{
    private String fd_name; //όνομασία  δραστηριότητας π.χ. φαγητό σε εστιατόριο
    private String fd_distance; //απόσταση εστιατορίου από ξενοδοχείο
    private String fd_place; //Τοποθεσία εστιατορίου
    private double fd_cost; //Κόστος φαγητού, ποτού κ.λ.π.
    private String fd_type; //είδος κουζίνας, μπαρ κ.λ.π.

    @Override
    public String toString() 
    {
        return "FoodDrink{" + "fd_name=" + fd_name + ", fd_distance=" + fd_distance + ", fd_place=" + fd_place + ", fd_cost=" + fd_cost + ", fd_type=" + fd_type + '}';
    }

    public FoodDrink(String fd_name, String fd_distance, String fd_place, double fd_cost, String fd_type) 
    {
        this.fd_name = fd_name;
        this.fd_distance = fd_distance;
        this.fd_place = fd_place;
        this.fd_cost = fd_cost;
        this.fd_type = fd_type;
    }
    
    public FoodDrink()
    {
    }

    public String getFd_name() 
    {
        return fd_name;
    }

    public void setFd_name(String fd_name)
    {
        this.fd_name = fd_name;
    }

    public String getFd_distance() 
    {
        return fd_distance;
    }

    public void setFd_distance(String fd_distance) {
        this.fd_distance = fd_distance;
    }

    public String getFd_place() {
        return fd_place;
    }

    public void setFd_place(String fd_place) {
        this.fd_place = fd_place;
    }

    public double getFd_cost() {
        return fd_cost;
    }

    public void setFd_cost(double fd_cost) {
        this.fd_cost = fd_cost;
    }

    public String getFd_type() {
        return fd_type;
    }

    public void setFd_type(String fd_type) {
        this.fd_type = fd_type;
    }
}