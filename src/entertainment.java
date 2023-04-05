 //entertainment.java
 package projectsiamoglou;
 import java.util.Date;
 
 public class Entertaiment  //Περιγραφή ψυχαγωγικής δραστηριότητας
 {
     private String ent_name; //όνομασία ψυχαγωγικής δραστηριότητας π.χ. θέατρο σινεμά
     private String ent_distance; //απόσταση θεάτρου, σινεμά από ξενοδοχείο
     private String ent_place; //τοποθεσία ψυχαγωγικής δραστηριότητας
     private Date ent_dt; //Ημέρα και Ώρα 
     private int ent_capacity; //Χωρητικότητα θεάτρου, σινεμά κ.λ.π.
     private double ent_cost; //Κόστος ψυχαγωγικής δραστηριότητας
 
     @Override
     public String toString() 
     {
         return "Entertaiment{" + "ent_name=" + ent_name + ", ent_distance=" + ent_distance + ", ent_place=" + ent_place + ", ent_dt=" + ent_dt + ", ent_capacity=" + ent_capacity + ", ent_cost=" + ent_cost + '}';
     }
 
     public Entertaiment(String ent_name, String ent_distance, String ent_place, Date ent_dt, int ent_capacity, double ent_cost) {
         this.ent_name = ent_name;
         this.ent_distance = ent_distance;
         this.ent_place = ent_place;
         this.ent_dt = ent_dt;
         this.ent_capacity = ent_capacity;
         this.ent_cost = ent_cost;
     }
     
     public Entertaiment()
     {
         
     }
 
     public String getEnt_name() {
         return ent_name;
     }
 
     public void setEnt_name(String ent_name) {
         this.ent_name = ent_name;
     }
 
     public String getEnt_distance() {
         return ent_distance;
     }
 
     public void setEnt_distance(String ent_distance) {
         this.ent_distance = ent_distance;
     }
 
     public String getEnt_place() {
         return ent_place;
     }
 
     public void setEnt_place(String ent_place) {
         this.ent_place = ent_place;
     }
 
     public Date getEnt_dt() {
         return ent_dt;
     }
 
     public void setEnt_dt(Date ent_dt) {
         this.ent_dt = ent_dt;
     }
 
     public int getEnt_capacity() {
         return ent_capacity;
     }
 
     public void setEnt_capacity(int ent_capacity) {
         this.ent_capacity = ent_capacity;
     }
 
     public double getEnt_cost() {
         return ent_cost;
     }
 
     public void setEnt_cost(double ent_cost) {
         this.ent_cost = ent_cost;
     }
 