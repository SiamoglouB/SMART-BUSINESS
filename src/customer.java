//customer.java
package projectsiamoglou;
import java.util.ArrayList;

public class Customer //Περιγραφή Πελάτη
{
    private int ID; //Αριθμός ταυτότητας ή διαβατηρίου
    private String name;
    private String surname;
    private String type;
    private String gender;
    private int age;
    private String nationality;
    private String telephone;
    private String email;
    private String healthcomments; //σχόλια για πελάτη σχετικά με προβλήματα υγείας
    private String peronaldetails; //γενικές πληροφορίες για τον πελάτη π.χ. αλλεργεία σε φαγητά
    private boolean amea=false; //λογικό πεδίο τύπου true/false ανάλογα με το αν ο πελάτης ει-ναι ΑΜΕΑ ή όχι

    public boolean isAmea() 
    {
        return amea;
    }
    
    //Τα επομενα ArrayList θα συγκεντρώνουν όλες τις επιλογές του πελάτη
    private ArrayList <ArtHistory> art_his=new ArrayList <ArtHistory>();
    private ArrayList <Entertaiment> entert=new ArrayList <Entertaiment>();
    private ArrayList <FoodDrink> foodr=new ArrayList <FoodDrink>();
    private ArrayList <SportActivities> sportact=new ArrayList <SportActivities>();

    public ArrayList<ArtHistory> getArt_his() {
        return art_his;
    }

    public void setArt_his(ArrayList<ArtHistory> art_his) {
        this.art_his = art_his;
    }

    public ArrayList<Entertaiment> getEntert() {
        return entert;
    }

    public void setEntert(ArrayList<Entertaiment> entert) {
        this.entert = entert;
    }

    public ArrayList<FoodDrink> getFoodr() {
        return foodr;
    }

    public void setFoodr(ArrayList<FoodDrink> foodr) {
        this.foodr = foodr;
    }

    public ArrayList<SportActivities> getSportact() {
        return sportact;
    }

    public void setSportact(ArrayList<SportActivities> sportact) {
        this.sportact = sportact;
    }
 

    @Override
    public String toString() 
    {
        return "Customer{" + "ID=" + ID + ", name=" + name + ", surname=" + surname + ", type=" + type + ", gender=" + gender + ", age=" + age + ", nationality=" + nationality + ", tele-phone=" + telephone + ", email=" + email + ", healthcomments=" + healthcomments + ", pero-naldetails=" + peronaldetails + '}';
    }

    public Customer(int ID, String name, String surname, String type, String gender, int age, String nationality, String telephone, String email, String healthcomments, String peronalde-tails) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.telephone = telephone;
        this.email = email;
        this.healthcomments = healthcomments;
        this.peronaldetails = peronaldetails;
    }
    
     public Customer()
     {
     }

    public int getID() 
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getSurname() 
    {
        return surname;
    }

    public void setSurname(String surname) 
    {
        this.surname = surname;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getGender() 
    {
        return gender;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public int getAge() 
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHealthcomments() {
        return healthcomments;
    }

    public void setHealthcomments(String healthcomments) {
        this.healthcomments = healthcomments;
    }

    public String getPeronaldetails() {
        return peronaldetails;
    }

    public void setPeronaldetails(String peronaldetails) {
        this.peronaldetails = peronaldetails;
    }
}