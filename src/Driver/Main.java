package Driver;

import DataStore.DataStore;
import Services.AccountCreationService;
import Services.AdvancedSearch;
import entities.People;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataStore dataStore = new DataStore();
        AccountCreationService accountCreationService = new AccountCreationService(dataStore);
        AdvancedSearch advancedSearch = new AdvancedSearch(dataStore);
        Scanner sc = new Scanner(System.in);
        String ip = "";
        while(!ip.equalsIgnoreCase("quit")){
            ip = sc.nextLine();
            String[] ipArray = ip.split(" ");
            String command = ipArray[0];
            switch(command){
                case "add":
                    if(ipArray[2].equalsIgnoreCase("People")){
                        ArrayList<String> arr = new ArrayList<String>();
                        arr.add(ipArray[6]);
                        accountCreationService.createPeople(ipArray[1],ipArray[3],ipArray[4],Float.parseFloat(ipArray[5]),arr,ipArray[7],dataStore);
                    }
                    else if(ipArray[2].equalsIgnoreCase("Company")){
                        ArrayList<String> arr = new ArrayList<String>();
                        arr.add(ipArray[6]);
                        accountCreationService.createCompany(ipArray[1],ipArray[3],ipArray[4],Float.parseFloat(ipArray[5]),arr,ipArray[7],dataStore);
                    }
                    else{
                        System.out.println("Invalid Category");
                    }
                    break;
                case "AdvanceSearch":
                    ArrayList<String> keywords = new ArrayList<String>();
                    for(int i =1;i<=ipArray.length-1;i++){
                        keywords.add(ipArray[i]);
                    }
                    System.out.println("List of people:");
                    advancedSearch.advSearchPeople(keywords);
                    System.out.println();
                    System.out.println("List of companies");
                    advancedSearch.advSearchCompany(keywords);
                    break;
                case "delete":
                    String s = ipArray[2];
                    long x = Long.parseLong(s);
                    if(ipArray[1].equalsIgnoreCase("People")){
                        accountCreationService.deleteFromPeople(x);
                    }
                    else{
                        accountCreationService.deleteFromCompany(x);
                    }
                    break;
                case "modify":
                    String s1 = ipArray[2];
                    long id = Long.parseLong(s1);
                    if(ipArray[1].equalsIgnoreCase("People")){
                        accountCreationService.modifyPeopleData(id,ipArray[3],ipArray[4],ipArray[5],ipArray[6],ipArray[7],ipArray[8]);
                    }
                    else if(ipArray[1].equalsIgnoreCase("Company")){
                        accountCreationService.modifyCompanyData(id,ipArray[3],ipArray[4],ipArray[5],ipArray[6],ipArray[7],ipArray[8]);
                    }
                    else{
                        System.out.println("Invalid Command");
                    }
                    break;
                case "EnhancedSearch":
                    String attr = ipArray[1];
                    String val = ipArray[2];
                    accountCreationService.enhancedSearch(attr,val);
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }
}
