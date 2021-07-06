package Services;

import DataStore.DataStore;
import entities.Company;
import entities.People;

import java.util.ArrayList;

public class AccountCreationService {
    DataStore dataStore;
    public AccountCreationService(DataStore dataStore){
        this.dataStore = dataStore;
    }
    public void createPeople(String name, String CompanyName, String Designation, float experience, ArrayList<String> skillSet, String Location,DataStore dataStore){
        People obj = new People(name, CompanyName, Designation, experience, skillSet, Location,dataStore);
        long id = obj.getID();
        dataStore.updatePeopleById(id, obj);
    }
    public void createCompany(String name, String CompanyName, String Designation, float experience, ArrayList<String> skillSet, String Location, DataStore dataStore){
        Company obj = new Company(name, CompanyName, Designation, experience, skillSet, Location,dataStore);
        long id = obj.getID();
        dataStore.updateCompanyById(id, obj);
    }
    public void deleteFromPeople(long x){
        dataStore.deleteAllPeople(x);
    }
    public void deleteFromCompany(long x){
        dataStore.deleteAllCompany(x);
    }
    public void modifyPeopleData(long id,String name,String CompanyName, String Designation, String Experience, String skillSet, String Location){
        People obj = dataStore.getPeople(id);
        if(obj==null){
            System.out.println("Invalid id number");
            return;
        }
        obj.modify(name,CompanyName,Designation,Experience,skillSet,Location);
        ArrayList<String> arr = new ArrayList<>();
        arr.add(skillSet);
        dataStore.performDataUpdatesPeople(id, name,"People",CompanyName, Designation, Float.parseFloat(Experience), arr, Location);
    }
    public void modifyCompanyData(long id,String name,String CompanyName, String Designation, String Experience, String skillSet, String Location){
        Company obj = dataStore.getCompany(id);
        if(obj==null){
            System.out.println("Invalid id number");
            return;
        }
        obj.modify(name,CompanyName,Designation,Experience,skillSet,Location);
        ArrayList<String> arr = new ArrayList<>();
        arr.add(skillSet);
        dataStore.performDataUpdatesCompany(id, name,"People",CompanyName, Designation, Float.parseFloat(Experience), arr, Location);
    }
    public void enhancedSearch(String attr, String val){
        System.out.println("List of People");
        dataStore.enhancedSearchPeople(attr,val);
        System.out.println();
        System.out.println("List of Companies");
        dataStore.enhancedSearchCompany(attr,val);
    }
}
