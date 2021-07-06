package Services;

import DataStore.DataStore;
import entities.Company;
import entities.People;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdvancedSearch {
    DataStore dataStore;
    public AdvancedSearch(DataStore dataStore){
        this.dataStore = dataStore;
    }

    public void advSearchPeople(ArrayList<String> arr){
        ArrayList<Long> people = dataStore.advSearchPeople(arr);
        ArrayList<People> userList = dataStore.getPeopleById(people);
        Collections.sort(userList, new sortPeople());
        for(People i:userList){
            i.display();
        }
        return;
    }
    public void advSearchCompany(ArrayList<String> arr){
        ArrayList<Long> company = dataStore.advSearchCompany(arr);
        ArrayList<Company> userList = dataStore.getCompanyById(company);
        Collections.sort(userList, new sortCompany());
        for(Company i:userList){
            i.display();
        }
    }
}

class sortPeople implements Comparator<People>{
    public int compare(People p1 , People p2){
        if(p2.getExperience()!=p1.getExperience()){
            return (int)(p2.getExperience()-p1.getExperience());
        }
        else{
            return (int)(p1.getID()-p2.getID());
        }
    }
}

class sortCompany implements Comparator<Company>{
    public int compare(Company p1 , Company p2){
        if(p2.getExperience()!=p1.getExperience()){
            return (int)(p2.getExperience()-p1.getExperience());
        }
        else{
            return (int)(p1.getID()-p2.getID());
        }
    }
}

        //add sameer People fk SDE1 10 smart bang
        //add duddu People fk SDE1 12 creative bang
        //add shashwat People fk SDE1 2 intell bang
        //add mridul People deloitte analyst 2 hard mumbai