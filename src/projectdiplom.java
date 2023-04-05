//projectdiplom.java
package projectsiamoglou;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class ProjectDiplom
{
    static final String FileLocation1 = "C:/siamoglou/customers.txt";
    static final String FileLocation2 = "C:/siamoglou/sel_statistics.txt";
    static final String FileLocation3 = "C:/siamoglou/cust_statistics.txt";
    static final Gson gson = new Gson();
    
    static int cust_act=0,anc_act=0,entairt_act1=0,entairt_act2=0,entairt_act3=0,athl_act=0,fddr_act,men=0,women=0,totalcust=0,indiv=0,group=0,europe=0,usa=0,other=0;
    static int pos=-1;
    
    static ArrayList <Customer> customers=new  ArrayList <Customer>();
    public static void main(String[] args)
    {
       int ch1,ch2,ch3,ch4;
       String user_selections="";
       String id,name,surname,type,gender,nationality,telephone,email,healthcomments,peronaldetails;
       int age;
       boolean ch0end,ch1end,ch2end,ch3end,ch4end;
       int user_id,i=0;
       boolean found;
  
       do
       {
           ch1=Integer.parseInt(JOptionPane.showInputDialog("1.Είσοδος ως Πελάτης\n2.Είσοδος ως Admin\n3.Έξοδος Εφαρμογής"));
           
           ch0end=false;
           
           switch(ch1)
           {
               case 1:  
                        JOptionPane.showMessageDialog(null,"Εισήλθατε ως Πελάτης.");
                        user_id= Integer.parseInt(JOptionPane.showInputDialog("Δώστε το ID σας"));
                        found=false;
                        
                        found=ReadFromFile1(user_id);
                        
                        for (i=0;i<customers.size();i++)
                            if (user_id==customers.get(i).getID())
                            {
                                found=true;
                                pos=i;
                                //System.out.println("O PELATHS BRETHIKE KAI EINAI STH THESH "+i);
                                break;
                            }
                        
                        if (found==false)
                        {
                            String namecust=JOptionPane.showInputDialog("Δώσε Όνομα Πελάτη");
                            String surnamecust=JOptionPane.showInputDialog("Δώσε Επώνυμο Πελάτη");
                            String custtype=JOptionPane.showInputDialog("Δώσε Τύπο Πελάτη (I)ndividual/(G)roup");
                            String custsex=JOptionPane.showInputDialog("Δώσε Φύλο Πελάτη (Μ)an/(W)oman");
                            int custage=Integer.parseInt(JOptionPane.showInputDialog("Δώσε Ηλικία Πελάτη"));
                            String custcountry=JOptionPane.showInputDialog("Δώσε Εθνικότητα Πελάτη (E)urope, (U)sa, (O)ther");
                            
                            Customer cust=new Custom-er(user_id,namecust,surnamecust,custtype,custsex,custage,custcountry,JOptionPane.showInputDialog("Δώσε Τηλέφωνο Πελάτη"),JOptionPane.showInputDialog("Δώσε Email Πελάτη"),JOptionPane.showInputDialog("Δώσε Αλλεργίες Πελάτη (aller-gies/nothing"),JOptionPane.showInputDialog("Δώσε Σχόλια Πελάτη"));
                            customers.add(cust);
                            pos++;
                            
                            WriteToFile(gson.toJson(cust),1);
                             
                            user_selections="";
                            cust_act=0;
                            
                            totalcust++;//αύξηση μετρητή πελατών
                        
                            if (custsex.compareTo("m")==0 || (custsex.compareTo("M")==0))
                                men++;//αύξηση μετρητή ανδρών πελατών
                            else
                                if (custsex.compareTo("w")==0 || (custsex.compareTo("W")==0))
                                    women++;//αύξηση μετρητή γυναικών πελατών
                            
                            
                            if (custtype.compareTo("i")==0 || (custtype.compareTo("I")==0))
                                indiv++;//αύξηση μετρητή πελατών που δεν ανήκουν σε οργανωμένο γκρουπ
                            else
                                if (custtype.compareTo("g")==0 || (custtype.compareTo("G")==0))
                                    group++;//αύξηση πελατών που ανήκουν σε οργανωμένο γκρουπ
                          
                            
                            if (custcountry.compareTo("e")==0 || (custtype.compareTo("E")==0))
                                europe++;//αύξηση μετρητή πελατών με προέλευση Ευρώπη
                            else
                                 if (custcountry.compareTo("u")==0 || (custtype.compareTo("U")==0))
                                    usa++;//αύξηση μετρητή πελατών με προέλευση HΠΑ
                                 else
                                     if (custcountry.compareTo("o")==0 || (custtype.compareTo("O")==0))
                                        other++;//αύξηση μετρητή πελατών με προέλευση άλλη χώρα
                            
                        }

                     
                        do
                        {
                            ch1end=false;
                        
                          
                            do
                            {
                                ch2end=false;
                                
                                ch2=Integer.parseInt(JOptionPane.showInputDialog("Menu Πελάτη\n1. Ε-πιλογή Δραστηριότητας Πελάτη\n2. Εμφάνιση Λίστας Ατομικών Προτιμήσεων-Επιλογών Πε-λάτη\n3. Έξοδος από Menu Πελάτη"));


                                switch(ch2)
                                {
                                     case 1: 
                                        do //1.Επιλογή Δραστηριότητας Πελάτη
                                        {
                                           ch3end=false;
                                            
                                           ch3=Integer.parseInt(JOptionPane.showInputDialog("Menu Δραστηριοτήτων\n1. Επίσκεψη σε Αρχαιολογικό Χώρο\n2. Ψυχαγωγία\n3. Αθλητικές Δραστη-ριότητες\n4. Φαγητό-Ποτό\n5. Έξοδος από Menu Δραστηριοτήτων Πελάτη"));

                                            switch(ch3)
                                            {
                                                case 1: 
                                                       do
                                                       {
                                                            ch4end=false;

                                                            //1.Επίσκεψη σε Αρχαιολογικό Χώρο
                                                            ch4=Integer.parseInt(JOptionPane.showInputDialog("Λίστα Επισκέψεων σε Αρχαιολογικούς Χώρους\n1.Επίσκεψη σε Ακρόπολη/Μουσείο Ακρόπολης\n2.Επίσκεψη σε Μουσείο Ολυμπί-ας\n3.Επίσκεψη σε Μουσείο Δελφών\n4. Έξοδος"));

                                                            switch(ch4)
                                                            {
                                                                 case 1:
                                                                         user_selections="Δραστηριότητα "+(cust_act+1)+": Επίσκεψη σε Ακρόπολη/Μουσείο Ακρόπολης\n";
                                                                         JOption-Pane.showMessageDialog(null,user_selections);
                                                                         cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                         anc_act++; //αύξηση μετρητή επισκέψεων σε μου-σεία και αρχαιολογικούς χώρους
                                                                         ArtHistory art_his=new ArtHistory("Moυσείο Ακρόπολης","Επίσκεψη-Ξενάγηση",10,"Αθήνα","Ανοικτό: 9:00-18:00.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για την ξενάγηση",20);
                                                                         customers.get(pos).getArt_his().add(art_his);
                                                                         break;

                                                                 case 2:
                                                                         user_selections="Δραστηριότητα "+(cust_act+1)+": Επίσκεψη σε Μουσείο Ολυμπίας\n";
                                                                         JOption-Pane.showMessageDialog(null,user_selections);
                                                                         cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                         anc_act++; //αύξηση μετρητή επισκέψεων σε μου-σεία και αρχαιολογικούς χώρους
                                                                         ArtHistory art_his2=new ArtHistory("Moυσείο Ολυμπίας","Επίσκεψη-Ξενάγηση",15,"Ολυμπία","Ανοικτό: 9:30-17:30.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για την ξενάγηση",25);
                                                                         customers.get(pos).getArt_his().add(art_his2);
                                                                         break;

                                                                case 3:
                                                                         user_selections="Δραστηριότητα "+(cust_act+1)+": Επίσκεψη σε Μουσείο Δελφών\n";
                                                                         JOption-Pane.showMessageDialog(null,user_selections);
                                                                         cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                         anc_act++; //αύξηση μετρητή επισκέψεων σε μου-σεία και αρχαιολογικούς χώρους
                                                                         ArtHistory art_his3=new ArtHistory("Moυσείο Δελφών","Ξενάγηση",15,"Δελφών","Ανοικτό: 9:30-17:30.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχε-ται καροτσάκι για την ξενάγηση",15);
                                                                         customers.get(pos).getArt_his().add(art_his3);
                                                                         break;

                                                                 case 4: ch4end=true;
                                                                         break;
                                                            }
                                                       }
                                                       while (ch4end==false);
                                                       
                                                       break;

                                                       
                                                 case 2:
                                                       do
                                                       {
                                                            ch4end=false;
                                                            
                                                            //2.Ψυχαγωγία
                                                            ch4=Integer.parseInt(JOptionPane.showInputDialog("Menu Ψυχαγωγικών Δραστηριοτήτων\n1.Θέατρο\n2.Σινεμά\n3.Συναυλία-Παράσταση\n4. Έξοδος"));

                                                            switch(ch4)
                                                            {
                                                                case 1:
                                                                           user_selections="Δραστηριότητα "+(cust_act+1)+": Θεατρική Παράσταση\n";
                                                                           JOption-Pane.showMessageDialog(null,user_selections);
                                                                           cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                           entairt_act1++; //αύξηση μετρητή ψυχαγωγικών δραστηριοτήτων
                                                                           Entertaiment enter1=new Entertaiment("Οι συμπέθεροι","2 km","Θέατρο Αθηνά.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για την παράσταση",new Date(),150,20);
                                                                           customers.get(pos).getEntert().add(enter1);
                                                                           break;

                                                                case 2:
                                                                           user_selections="Δραστηριότητα "+(cust_act+1)+": Κινηματογραφική Ταινία\n";
                                                                           JOption-Pane.showMessageDialog(null,user_selections);
                                                                           cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                           entairt_act2++; //αύξηση μετρητή ψυχαγωγικών δραστηριοτήτων
                                                                           Entertaiment enter2=new Entertaiment("No Time To Die","4 km","Mall Αθηνών.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για την ταινία",new Date(),300,25);
                                                                           customers.get(pos).getEntert().add(enter2);
                                                                           break;

                                                                case 3:
                                                                           user_selections="Δραστηριότητα "+(cust_act+1)+": Μουσική Παράσταση-Συναυλία\n";
                                                                           JOption-Pane.showMessageDialog(null,user_selections);
                                                                           cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                           entairt_act3++; //αύξηση μετρητή ψυχαγωγικών δραστηριοτήτων
                                                                           Entertaiment enter3=new Enter-taiment("Συναυλία Κλασσικής Μουσικής","5 km","Μέγαρο Μουσικής. \nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για την παράσταση",new Date(),600,35);
                                                                           customers.get(pos).getEntert().add(enter3);
                                                                           break;

                                                                case 4:   ch4end=true;     
                                                                          break;
                                                            }
                                                       }
                                                       while (ch4end==false);

                                                       break;
                                                         

                                                 case 3:

                                                       do
                                                       {
                                                            ch4end=false;
  
                                                            //3. Αθλητικές Δραστηριότητες
                                                             ch4=Integer.parseInt(JOptionPane.showInputDialog("Menu Αθλητικών Δραστηριοτήτων\n1.Γυμναστική-Άθληση στις εγκαταστάσεις του Ξενοδοχείου\n2.Γυμναστική-Άθληση σε κοντινό γυμναστήριο/Αθλητική Εγκατάσταση\n3.Κολύμβηση\n4. Τένις\n5.Έξοδος"));

                                                             switch(ch4)
                                                             {
                                                                 case 1:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Γυμναστική-Άθληση στις εγκαταστάσεις του Ξενοδοχείου\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή αθλητικών δραστηριοτήτων
                                                                            SportActivities sport1=new SportActivi-ties("Γυμναστική με Όργανα","Γυμναστική",60,"0 km","Γυμναστήριο Ξενοδοχείου","Καθημερινόα από 9:00-21:00");
                                                                            customers.get(pos).getSportact().add(sport1);
                                                                            break;                                                           

                                                                 case 2:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Γυμναστική-Άθληση σε κοντινό γυμναστήριο/Αθλητική Εγκατάσταση\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή αθλητικών δραστηριοτήτων
                                                                            SportActivities sport2=new SportActivi-ties("Τρέξιμο σε Γυμναστήριο","Τρέξιμο",90,"3 km","Γυμναστήριο Φιλοθέης","Καθημερινά από 10:00-20:00");
                                                                            customers.get(pos).getSportact().add(sport2);
                                                                            break;  

                                                                 case 3:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Κολύμβηση\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή αθλητικών δραστηριοτήτων
                                                                            SportActivities sport3=new SportActivi-ties("Εκμάθηση Κολύμβησης","Κολύμβηση",45,"6 km","Κολυμβητήριο Φαλήρου","Απόγευμα από 18:00-20:00");
                                                                            customers.get(pos).getSportact().add(sport3);
                                                                            break; 

                                                                 case 4:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Τένις\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή αθλητικών δραστηριοτήτων
                                                                            SportActivities sport4=new SportActivi-ties("Εκμάθηση Τένις","Τένις",60,"8 km","Γήπεδο ΟΑΚΑ","Μεσημέρια από 14:00-17:00");
                                                                            customers.get(pos).getSportact().add(sport4);
                                                                            break;            

                                                                 case 5:   ch4end=true;
                                                                           break;
                                                            }
                                                       }
                                                       while (ch4end==false);
                                                         
                                                       break;
                                                       

                                                 case 4: 
                                                       do
                                                       {
                                                            ch4end=false;
  
                                                            //4.Φαγητό-Ποσό
                                                             ch4=Integer.parseInt(JOptionPane.showInputDialog("Menu για Φαγητό-Ποτό\n1.Φαγητό-Ποτό στο χώρο του Ξενοδοχείο\n2.Φαγητό σε εξωτερικό Eστιατόριο\n3.Ποτό σε club\n4. Έξοδος"));

                                                             switch(ch4)
                                                             {
                                                                 case 1:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Φαγητό-Ποτό στο χώρο του Ξενοδοχείου\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            fddr_act++; //αύξηση μετρητή δραστηριοτήτων φαγητού-ποτού 
                                                                            if (custom-ers.get(pos).getHealthcomments().compareTo("allergies")==0)
                                                                            {
                                                                               FoodDrink food1=new FoodDrink("Διατίθεται ειδικό μενού Φαγητού στο εστιατόριο του Ξενοδοχείου λόγω αλλεργειων του πελάτη","0 km","Εστιατόριο Αθηνά στο Ξενοδοχείο",15,"Γεύμα-Δείπνο");
                                                                               customers.get(pos).getFoodr().add(food1);
                                                                            }
                                                                            else
                                                                            {
                                                                               FoodDrink food1=new FoodDrink("Φαγητό στο εστιατόριο του Ξενοδοχείου","0 km","Εστιατόριο Αθηνά στο Ξενοδοχείο",15,"Γεύμα-Δείπνο");
                                                                               customers.get(pos).getFoodr().add(food1);
                                                                            }
                                                                            break; 

                                                                 case 2:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Φαγητό σε εξωτερικό Eστιατόριο\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή δραστηριοτήτων φαγητού-ποτού
                                                                            
                                                                            if (custom-ers.get(pos).getHealthcomments().compareTo("allergies")==0)
                                                                            {
                                                                                FoodDrink food2=new FoodDrink("Διατίθεται ειδικο μενού στο εστιατόριο Φαντασία λόγω αλλεργειών του πελάτη","9 km","Εστιατόριο στον Πειραιά",20,"Δείπνο.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για το εστιατόριο");
                                                                                customers.get(pos).getFoodr().add(food2);
                                                                            }
                                                                            else
                                                                            {
                                                                               FoodDrink food2=new FoodDrink("Φαγητό στο εστιατόριο Φαντασία","9 km","Εστιατόριο στον Πειραιά",20,"Δείπνο.\nΑν ο πελάτης είναι ΑΜΕΑ παρέχεται καροτσάκι για το εστιατόριο");
                                                                               customers.get(pos).getFoodr().add(food2);
                                                                            }
                                                                            
                                                                            
                                                                           
                                                                            break; 

                                                                 case 3:
                                                                            user_selections="Δραστηριότητα "+(cust_act+1)+": Ποτό σε Club\n";
                                                                            JOption-Pane.showMessageDialog(null,user_selections);
                                                                            cust_act++; //αύξηση μετρητή δραστηριοτήτων πελάτη
                                                                            athl_act++; //αύξηση μετρητή δραστηριοτήτων φαγητού-ποτού
                                                                            FoodDrink food3=new FoodDrink("Ποτό/Snack στο club Metropolis","2 km","Club στην Πλάκα",18,"Ποσό-Διασκέδαση");
                                                                            customers.get(pos).getFoodr().add(food3);
                                                                            break; 

                                                                 case 4:    ch4end=true;     
                                                                            break;

                                                             }
                                                       }
                                                       while (ch4end==false);
                                                         
                                                        break;

                                                 case 5: ch3end=true;
                                                         break;
                                             }
                                        }
                                        while (ch3end==false);
                                        
                                        //ch2end=true;
                                        break;
                                        

                                case 2: if (user_selections.compareTo("")==0)
                                             JOptionPane.showMessageDialog(null,"Δεν υπάρχουν επιλογές-προτιμήσεις του πελάτη"+user_selections);
                                        else
                                        {
                                            String total="";
                                            
                                            if (customers.get(pos).getArt_his().size()!=0)
                                            {
                                                total+="\nΛίστα Επιλεγμένων Επισκέψεων σε Αρχαιολογικούς Χώρους:\n";
                                                total+="=======================================\n";

                                                for (i=0;i<customers.get(pos).getArt_his().size();i++)   
                                                {
                                                     total+="\nΕίδος Δραστηριότητας: "+customers.get(pos).getArt_his().get(i).getArthist_type()+"\n";
                                                     total+="Περιοχή: "+customers.get(pos).getArt_his().get(i).getArthist_name()+"\n";
                                                     total+="Τοποθεσία: "+customers.get(pos).getArt_his().get(i).getArthist_place()+"\n";
                                                     total+="Ώρες Επισκέψεων: "+customers.get(pos).getArt_his().get(i).getArthist_timetable()+"\n";
                                                     total+="Κόστος: "+customers.get(pos).getArt_his().get(i).getArthist_cost()+"\n";
                                                     total+="Απόσταση από Ξενοδοχείο Πελάτη: "+customers.get(pos).getArt_his().get(i).getArthist_distance()+"\n";
                                                     total+="-------------------------------------------------------\n";
                                                }
                                            }

                                           if (customers.get(pos).getEntert().size()!=0)
                                           { 
                                                total+="\nΛίστα Επιλεγμένων Ψυχαγωγικών Δραστηριοτήτων:\n";
                                                to-tal+="===========================================\n";


                                                for (i=0;i<customers.get(pos).getEntert().size();i++)  
                                                {
                                                      total+="\nΕίδος Δραστηριότητας: "+customers.get(pos).getEntert().get(i).getEnt_name()+"\n";
                                                      total+="Απόσταση από Ξενοδοχείο Πελάτη: "+customers.get(pos).getEntert().get(i).getEnt_distance()+"\n";
                                                      total+="Τοποθεσία Δραστηριότητας: "+customers.get(pos).getEntert().get(i).getEnt_place()+"\n";
                                                      total+="Κόστος Δραστηριότητας: "+customers.get(pos).getEntert().get(i).getEnt_cost()+"\n";
                                                      total+="Χωρητικότητα Δραστηριότητας: "+customers.get(pos).getEntert().get(i).getEnt_capacity()+"\n";
                                                }
                                           }
                                               
                                           if (customers.get(pos).getSportact().size()!=0)
                                           {
                                                total+="\nΛίστα Επιλεγμένων Αθλητικών Δραστηριοτήτων:\n";
                                                total+="=======================================\n";

                                                for (i=0;i<customers.get(pos).getSportact().size();i++)   
                                                {
                                                      total+="\nΕίδος Δραστηριότητας: "+customers.get(pos).getSportact().get(i).getSportact_name()+"\n";
                                                      total+="Τύπος Δραστηριότητας: "+customers.get(pos).getSportact().get(i).getSportact_type()+"\n";
                                                      total+="Διάρκεια Δραστηριότητας: "+customers.get(pos).getSportact().get(i).getSportact_duration()+"\n";
                                                      total+="Τοποθεσία Δραστηριότητας: "+customers.get(pos).getSportact().get(i).getSportact_place()+"\n";
                                                      total+="Ωράριο Λειτουργίας Αθλητικού Τόπου: "+customers.get(pos).getSportact().get(i).getSportact_timetable()+"\n";
                                                      total+="Απόσταση Αθκητικού Τόπου από Ξενοδοχείο Πελάτη: "+customers.get(pos).getSportact().get(i).getSportact_distance()+"\n";
                                                }  
                                           }
                                              
                                           if (customers.get(pos).getFoodr().size()!=0)
                                           {
                                                total+="\nΛίστα Επιλεγμένων Δραστηριοτήτων Αναψυχής με Φα-γητό-Ποτό:\n";
                                                to-tal+="===================================================\n";

                                               for (i=0;i<customers.get(pos).getFoodr().size();i++)   
                                               {
                                                    total+="\nΟνομασία Δραστηριότητας: "+customers.get(pos).getFoodr().get(i).getFd_name()+"\n";
                                                    total+="Τύπος Δραστηριότητας: "+customers.get(pos).getFoodr().get(i).getFd_type()+"\n";
                                                    total+="Τοποθεσία Δραστηριότητας: "+customers.get(pos).getFoodr().get(i).getFd_place()+"\n";
                                                    total+="Απόσταση Restaurant/Club από Ξενοδοχείο Πελάτη: "+customers.get(pos).getFoodr().get(i).getFd_distance()+"\n";
                                                    total+="Κόστος Δραστηριότητας: "+customers.get(pos).getFoodr().get(i).getFd_cost()+"\n";
                                               }
                                           }
                                            
                                                                     
                                            JOptionPane.showMessageDialog(null,"Όλες οι επιλογές του Πελάτη είναι:\n"+total,"Λίστα Συνολικών Επιλογών",JOptionPane.INFORMATION_MESSAGE);
                               
                                        }
                                       
                                        //ch2end=true;
                                        break;

                                case 3: ch2end=true;
                                        break;

                            }
                            
                        }
                        while (ch2end==false);
                       
                        
                        ch1end=true;
                       
             }
             while (ch1end==false);
                
             break;
                               
             case 2:    ch2=Integer.parseInt(JOptionPane.showInputDialog("Δώστε το password σύνδεσης ως admin"));
             
                        if (ch2!=0)
                        {
                           JOptionPane.showMessageDialog(null,"Λάθος Password. H είσοδος ως Ad-min δεν είναι εφικτή");
                           ch0end=true;
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Είσοδος ως Admin");
                            
                            ReadFromFile2();

                            ch2=Integer.parseInt(JOptionPane.showInputDialog("1.Στατιστικά Στοιχεία Προτιμήσεων Πελατών\n2.Στατιστικά Στοιχεία Φύλλου/Τύπου/Προέλευσης Πελατών\n3.Έξοδος ως Admin"));

                            String res="";

                            switch(ch2)
                            {
                                case 1: 
                                        
                                        if (cust_act==0)
                                        {
                                            res="Δεν υπάρχουν στατιστικά στοιχεία προτιμήσεων πελατών";
                                            JOptionPane.showMessageDialog(null,res,"Στατιστικά Στοιχεία Προτιμησεων Πελατών",JOptionPane.INFORMATION_MESSAGE);
                                        }
                                        else
                                        {
                                            res+="Ποσόστό Επισκέψεων σε Αρχαιολογικούς Χώρους ="+(float)anc_act/cust_act*100+"%\n";
                                            res+="Ποσοστό Παρακολούθησης Θεατρικών Παραστάσεων ="+(float)entairt_act1/cust_act*100+"%\n";
                                            res+="Ποσοστό Παρακολούθησης Κινηματογραφικών Ταινιών ="+(float)entairt_act2/cust_act*100+"%\n";
                                            res+="Ποσοστό Παρακολούθησης Μουσικών Παραστάσεων-Συναυλιών ="+(float)entairt_act3/cust_act*100+"%\n";
                                            res+="Ποσοστό Άθλησης σε Γυμναστήρια/Εξωτερικούς Χώρους ="+(float)athl_act/cust_act*100+"%\n";       
                                            res+="Ποσοστό Διασκέδασης σε Εστιατόρια/Club ="+(float)fddr_act/cust_act*100+"%\n";       
                                            JOptionPane.showMessageDialog(null,res,"Στατιστικά Στοιχεία Προτιμησεων Πελατών",JOptionPane.INFORMATION_MESSAGE);
                                        }
                                         break;
                                        
                                        
                                case 2: res+="Ποσοστό Ανδρών Πελατών ="+(float)men/totalcust*100+"%\n";
                                        res+="Ποσοστό Γυναικών Πελατών ="+(float)women/totalcust*100+"%\n";
                                        res+="Ποσοστό Πελάτων που δεν ανήκουν σε ταξιδιωτικό γκρουπ="+(float)indiv/totalcust*100+"%\n";
                                        res+="Ποσοστό Πελάτων που ανήκουν σε ταξιδιωτικό γκρουπ="+(float)group/totalcust*100+"%\n";
                                        res+="Ποσοστό Πελάτων με προέλευση Ευρώπη="+(float)europe/totalcust*100+"%\n";
                                        res+="Ποσοστό Πελάτων με προέλευση Αμερική="+(float)usa/totalcust*100+"%\n";
                                        res+="Ποσοστό Πελάτων με προέλευση άλλη χώρα="+(float)other/totalcust*100+"%\n";
                                        JOptionPane.showMessageDialog(null,res,"Στατιστικά Στοιχεία Φύλ-λου/Τύπου/Προέλευσης Πελατών",JOptionPane.INFORMATION_MESSAGE);
                                        break;

                                case 3: ch0end=true;
                                        break;
                            }
                        }
                        break;      
                                     
                  
            case 3:  return;
           }
       }
       while (ch0end==false);
    }
    
    
    private static void WriteToFile(String myData,int type)
    {
        File myfile=null;
        
        if (type==1)
            myfile = new File(FileLocation1);
        else
            if (type==2)
                myfile = new File(FileLocation2);
             else
                if (type==3)
                    myfile = new File(FileLocation3);

        if (!myfile.exists()) //αν το αρχειο δεν υπάρχει
        {
            try 
            {
               
                File directory = new File(myfile.getParent()); 
                
                if (!directory.exists()) //αν δεν υπάρχει στο δίσκο ο κατάλογος
                    directory.mkdirs(); //τον δημιουργεί
               
                myfile.createNewFile();//δημιουργεί το αρχείο ports.txt στον κατάλογο ProjectZisis το οποίο αρχικά είναι κενό
            } 
            catch (IOException e) 
            {
                System.out.println("Σφάλμα: " + e.toString());
            }
        }

        try 
        {
            FileWriter myWriter;
            
            myWriter = new FileWriter(myfile.getAbsoluteFile(),true); //μετατρέπουμε το αρχείο σε αρχείο εξόδου

            BufferedWriter bufferWriter = new BufferedWriter(myWriter);//δημιουργούμε ένα buffer εξόδου και τον συσχετιζουμε με το αρχείο
           
            bufferWriter.write(myData.toString()); //Το περιεχόμενο του bufferWriter το καταχωρούμε στο αρχείο
          
            bufferWriter.close();

            if (type==1)
                 System.out.println("Τα στοιχεία αποθηκεύτηκαν στo αρχείο: " + FileLocation1 + " και ειναι τα ακόλουθα: " + myData + "\n");
           
            if (type==2)
                 System.out.println("Τα στοιχεία αποθηκεύτηκαν στo αρχείο: " + FileLocation2 + " και ειναι τα ακόλουθα: " + myData + "\n");
          
            if (type==3)
                 System.out.println("Τα στοιχεία αποθηκεύτηκαν στo αρχείο: " + FileLocation3 + " και ειναι τα ακόλουθα: " + myData + "\n");
           
        } 
        catch (IOException e)
        {
           System.out.println("Σφάλμα κατά την αποθήκευση στο αρχείο " + e.toString());
        }
    }
    
    
    public static boolean ReadFromFile1(int ID)
    {
        String res="";
        boolean found=false;
         
        File myfile = new File(FileLocation1);

        if (!myfile.exists())
            System.out.println("To αρχείο customers.txt δεν υπάρχει");

        InputStreamReader isReader;
        
        System.out.println("pel id="+ID);
        
        try 
        {
            isReader = new InputStreamReader(new FileInputStream(myfile), Standard-Charsets.UTF_8); //μετατρέπουμε το αρχείο σε αρχείο εισόδου
            JsonReader myReader=new JsonReader(isReader); //δημιουργούμε ενα buffer εισόδου
            
            Customer customer=null;
            int j=0;
            do
            {
              
                try
                {
                    customer=gson.fromJson(myReader,Customer.class);
                  
                    if (customer.getID()==ID)
                    {
                         customers.add(customer);
                         System.out.println("pel wih id  ="+ID+" found in pos="+j+" arrlistsize="+customers.size());
                         pos=j;
                         found=true;
                         break;
                    }
                    else
                    {
                          System.out.println("READ ID ="+customer.getID());
                          j++;
                    }
                } 
                catch (IllegalStateException  e)
                {
                    System.err.println(e.toString());
                } 
            }
            while (customer!=null); 
        }
        catch (Exception e)
        {
          // print_message("Σφάλμα κατά το διάβασμα από το αρχείο* " + e.toString());
        }

        if (found==true)
        {
            for (int i=0;i<customers.size();i++)
                if (customers.get(i).getID()==ID)
                {
                        res="Είστε καταχωρημένος ως πελάτης του Ξενοδοχείου με τα στοιχεία ID:"+customers.get(i).getID()+" και Όνοματεπώνυμο: " + custom-ers.get(i).getName()+","+customers.get(i).getSurname();
                        JOptionPane.showMessageDialog(null,res);
                        break;
                }
             return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Δεν είστε καταχωρημένος ως πελάτης του Ξε-νοδοχείουκαι θα εισάγετε τα στοιχεία σας");
            return false;
        }
    }
    
    
    public static void ReadFromFile2()
    {
        String res="";
        boolean found=false;
         
        File myfile = new File(FileLocation1);

        if (!myfile.exists())
            System.out.println("To αρχείο customers.txt δεν υπάρχει");

        InputStreamReader isReader;
        
        try 
        {
            isReader = new InputStreamReader(new FileInputStream(myfile), Standard-Charsets.UTF_8); //μετατρέπουμε το αρχείο σε αρχείο εισόδου
            JsonReader myReader=new JsonReader(isReader); //δημιουργούμε ενα buffer εισόδου
            
            Customer customer=null;
            
            totalcust=men=women=indiv=group=europe=usa=other=0; //αρχικοποίηση στατικών μετρητων
         
            do
            {
                try
                {
                    customer=gson.fromJson(myReader,Customer.class);
                  
                    totalcust++;//αύξηση μετρητή πελατών

                    if (customer.getGender().compareTo("m")==0 || (custom-er.getGender().compareTo("M")==0))
                        men++;//αύξηση μετρητή ανδρών πελατών
                    else
                         if (customer.getGender().compareTo("w")==0 || (custom-er.getGender().compareTo("W")==0))
                            women++;//αύξηση μετρητή γυναικών πελατών


                    if (customer.getType().compareTo("i")==0 || (custom-er.getType().compareTo("I")==0))
                        indiv++;//αύξηση μετρητή πελατών που δεν ανήκουν σε οργανωμένο γκρουπ
                    else
                       if (customer.getType().compareTo("g")==0 || (custom-er.getType().compareTo("G")==0))
                            group++;//αύξηση πελατών που ανήκουν σε οργανωμένο γκρουπ


                    if (customer.getNationality().compareTo("e")==0 || (custom-er.getNationality().compareTo("E")==0))
                        europe++;//αύξηση μετρητή πελατών με προέλευση Ευρώπη
                    else
                           if (customer.getNationality().compareTo("u")==0 || (custom-er.getNationality().compareTo("U")==0))
                                usa++;//αύξηση μετρητή πελατών με προέλευση HΠΑ
                         else
                               if (customer.getNationality().compareTo("o")==0 || (custom-er.getNationality().compareTo("O")==0))
                                    other++;//αύξηση μετρητή πελατών με προέλευση άλλη χώρα
                } 
                catch (IllegalStateException  e)
                {
                    System.err.println(e.toString());
                } 
            }
            while (customer!=null); 
        }
        catch (Exception e)
        {
          // print_message("Σφάλμα κατά το διάβασμα από το αρχείο* " + e.toString());
        }
    }
}
