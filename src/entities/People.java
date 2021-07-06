package entities;

import java.util.ArrayList;
import DataStore.DataStore;

import javax.crypto.spec.DESedeKeySpec;

public class People {
    //DataStore dataStore;
    static long idcount=0;
    long id;
    DataStore dataStore;
    String name;
    String category = "People";
    String CompanyName;
    String Designation;
    float Experience;
    ArrayList<String> skillSet;
    String Location;
    public People(String name, String CompanyName, String Designation, float experience, ArrayList<String> skillSet, String Location,DataStore data){
        this.dataStore = data;
        idcount++;
        id = idcount;
        this.name = name;
        this.CompanyName = CompanyName;
        this.Location = Location;
        this.Designation = Designation;
        this.Experience = experience;
        this.skillSet = skillSet;
        dataStore.performDataUpdatesPeople(id, name,category,CompanyName, Designation, experience, skillSet, Location);
    }
    public void setName(String name){
        this.name =  name;
    }
    public void setCompanyName(String name){
        this.CompanyName = name;
    }
    public void setDesignation(String des){
        this.Designation = des;
    }
    public void setExperience(float num){
        this.Experience = num;
    }
    public void deleteSkill(String skill){
        skillSet.remove(skill);
    }
    public void addSkill(String skill){
        skillSet.add(skill);
    }
    public void display(){
        System.out.print("name: "+name+" category: "+category+" CompanyName: "+CompanyName+" Designation: "+Designation+" Exp: "+Experience+" Location: "+Location);
        System.out.print(" Skill Set: ");
        for(String i: skillSet){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public long getID(){
        return this.id;
    }
    public void modify(String name,String CompanyName, String Designation, String Experience, String skillSet, String Location){
        this.name = name;
        this.Designation=Designation;
        this.CompanyName = CompanyName;
        this.Experience = Float.parseFloat(Experience);
        this.Location = Location;
        ArrayList<String> temp = new ArrayList<String>();
        temp.add(skillSet);
        this.skillSet = temp;
        //add sameer people fk SDE1 10 Smart bang
        //modify people 1 sameer flip SDE2 12 efficient US
        //add sameer people fk SDE1 10 Smart bang
        //add duddu people fk designer 2 creative bang
        //add shashwat people deloitte analyst 1 efficient hyderabad
    }
    public String getName(){
        return this.name;
    }
    public String getCategory(){
        return this.category;
    }
    public String getCompanyName(){
        return this.CompanyName;
    }
    public String getDesignation(){
        return this.Designation;
    }
    public float getExperience(){
        return this.Experience;
    }
    public String getLocation(){
        return this.Location;
    }
    public String getSkill(){
        String s = skillSet.get(0);
        return s;
    }
}
