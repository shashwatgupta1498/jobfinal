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
            //String[] ipArray = ip.split(" ");
            String command = ip;
            switch(command){

                case "add":
                    String[] ipArray = new String[8];
                    ipArray[0] = command;
                    int counter=1;
                    while(counter<=7){
                        ipArray[counter]=sc.nextLine();
                        counter++;
                    }
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
                    //String keys = sc.nextLine();
                    //String[] ipArray2= keys.split(" ");
                    ArrayList<String> keywords = new ArrayList<String>();
                    String advsrch = "";
                    while(!advsrch.equals("end")){
                        advsrch = sc.nextLine();
                        keywords.add(advsrch);
                    }
                    keywords.remove("end");
                    //System.out.println(keywords);
                    System.out.println("List of people:");
                    advancedSearch.advSearchPeople(keywords);
                    System.out.println();
                    System.out.println("List of companies");
                    advancedSearch.advSearchCompany(keywords);
                    break;
                case "delete":

                    String deleteCat = sc.nextLine();
                    String s = sc.nextLine();
                    long x = Long.parseLong(s);
                    if(deleteCat.equalsIgnoreCase("People")){
                        accountCreationService.deleteFromPeople(x);
                    }
                    else if(deleteCat.equalsIgnoreCase("Company")){
                        accountCreationService.deleteFromCompany(x);
                    }
                    else{
                        System.out.println("Invalid Category");
                    }
                    break;
                case "modify":
                    String[] ipArray4 = new String[9];
                    ipArray4[0] = command;
                    int j = 1;
                    while(j<=8){
                        ipArray4[j] = sc.nextLine();
                        j++;
                    }
                    String s1 = ipArray4[2];
                    long id = Long.parseLong(s1);
                    if(ipArray4[1].equalsIgnoreCase("People")){
                        accountCreationService.modifyPeopleData(id,ipArray4[3],ipArray4[4],ipArray4[5],ipArray4[6],ipArray4[7],ipArray4[8]);
                    }
                    else if(ipArray4[1].equalsIgnoreCase("Company")){
                        accountCreationService.modifyCompanyData(id,ipArray4[3],ipArray4[4],ipArray4[5],ipArray4[6],ipArray4[7],ipArray4[8]);
                    }
                    else{
                        System.out.println("Invalid Command");
                    }
                    break;
                case "EnhancedSearch":
                    //String[] ipArray5 = new String[3];
                    String attr = sc.nextLine();
                    String val = sc.nextLine();
                    accountCreationService.enhancedSearch(attr,val);
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }
}
