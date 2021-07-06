package DataStore;

import entities.Company;
import entities.People;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class DataStore {
    static HashMap<Long, ArrayList<String>> PeopleConsolidatedData;
    static HashMap<Long, ArrayList<String>> CompanyConsolidatedData;
    static HashMap<Long,People> PeopleById;
    static HashMap<Long,Company> CompanyById;
    static{
        PeopleConsolidatedData = new HashMap<>();
        CompanyConsolidatedData = new HashMap<>();
        PeopleById = new HashMap<>();
        CompanyById = new HashMap<>();
    }
    public void performDataUpdatesPeople(Long id, String name, String category,String CompanyName, String Designation, float experience, ArrayList<String> skillSet, String Location){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(name);
        arr.add(category);
        arr.add(CompanyName);
        arr.add(Designation);
        arr.add(String.valueOf(experience));
        String temp = "";
        for(int i=0;i<skillSet.size();i++){
            temp=skillSet.get(i);
            arr.add(temp);
        }
        arr.add(Location);
        PeopleConsolidatedData.put(id,arr);
        //System.out.print(PeopleConsolidatedData);
    }
    public void performDataUpdatesCompany(Long id, String name, String category,String CompanyName, String Designation, float experience, ArrayList<String> skillSet, String Location){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add(name);
        arr.add(category);
        arr.add(CompanyName);
        arr.add(Designation);
        arr.add(Float.toString(experience));
        String temp = "";
        for(int i=0; i<skillSet.size();i++){
            temp=skillSet.get(i);
            arr.add(temp);
        }
        arr.add(Location);
        CompanyConsolidatedData.put(id,arr);
    }
    public ArrayList<Long> advSearchPeople(ArrayList<String> arr){
        ArrayList<Long> res = new ArrayList<Long>();
        for(Map.Entry<Long,ArrayList<String>> entry:PeopleConsolidatedData.entrySet()){
            ArrayList<String> temp = entry.getValue();
            outerloop:
            for(int i=0;i<temp.size();i++){
                for(int j=0;j<arr.size();j++){
                    if(arr.get(j).equalsIgnoreCase(temp.get(i))){
                        res.add(entry.getKey());
                        break outerloop;
                    }
                }
            }
        }
        return res;
    }
    public ArrayList<Long> advSearchCompany(ArrayList<String> arr){
        ArrayList<Long> res = new ArrayList<Long>();
        for(Map.Entry<Long,ArrayList<String>> entry:CompanyConsolidatedData.entrySet()){
            ArrayList<String> temp = entry.getValue();
            outerloop:
            for(int i=0;i<temp.size();i++){
                for(int j=0;j<arr.size();j++){
                    if(arr.get(j).equalsIgnoreCase(temp.get(i))){
                        res.add(entry.getKey());
                        break outerloop;
                    }
                }
            }
        }
        return res;
    }
    public ArrayList<People> getPeopleById(ArrayList<Long> arr){
        ArrayList<People> res = new ArrayList<People>();
        for(int i =0;i<arr.size();i++){
            if(PeopleById.containsKey(arr.get(i))){
                res.add(PeopleById.get(arr.get(i)));
            }
        }
        return res;
    }
    public ArrayList<Company> getCompanyById(ArrayList<Long> arr){
        ArrayList<Company> res = new ArrayList<Company>();
        for(int i =0;i<arr.size();i++){
            if(CompanyById.containsKey(arr.get(i))){
                res.add(CompanyById.get(arr.get(i)));
            }
        }
        return res;
    }
    public void updatePeopleById(long id, People obj){
        PeopleById.put(id, obj);
    }
    public void updateCompanyById(long id, Company obj){
        CompanyById.put(id, obj);
    }
    public void deleteAllPeople(long id){
        if(!PeopleById.containsKey(id)){
            System.out.println("Invalid id number");
            return;
        }
        PeopleConsolidatedData.remove(id);
        PeopleById.remove(id);
    }
    public void deleteAllCompany(long id){
        if(!CompanyById.containsKey(id)){
            System.out.println("Invalid id number");
            return;
        }
        CompanyConsolidatedData.remove(id);
        CompanyById.remove(id);
    }
    public People getPeople(long id){
        return PeopleById.get(id);
    }
    public Company getCompany(long id) {
        return CompanyById.get(id);
    }
    public void enhancedSearchPeople(String attr, String val){
        ArrayList<People> res = new ArrayList<>();

        if(attr.equalsIgnoreCase("name")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getName().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Category")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getCategory().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("CompanyName")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getCompanyName().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Designation")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getDesignation().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Experience")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getExperience()== Float.parseFloat(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("SkillSet")){
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getSkill().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else{
            for(Map.Entry<Long,People> entry:PeopleById.entrySet()){
                if(entry.getValue().getLocation().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        //return res;
    }
    public void enhancedSearchCompany(String attr, String val){
        ArrayList<Company> res = new ArrayList<>();
        if(attr.equalsIgnoreCase("name")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getName().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Category")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getCategory().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("CompanyName")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getCompanyName().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Designation")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getDesignation().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("Experience")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getExperience()==Float.parseFloat(val)){
                    entry.getValue().display();
                }
            }
        }
        else if(attr.equalsIgnoreCase("SkillSet")){
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getSkill().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        else{
            for(Map.Entry<Long,Company> entry:CompanyById.entrySet()){
                if(entry.getValue().getLocation().equalsIgnoreCase(val)){
                    entry.getValue().display();
                }
            }
        }
        //return res;
    }
}
