import java.util.LinkedList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
class Person{
    private String firstName;
    private String lastName;
    private Integer id;

    Person(String firstName, String lastName, Integer id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public Integer getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getFirstName() + " " + this.getLastName();
    }
}

class SortPersonById implements Comparator {

    @Override
    public int compare(Object p1, Object p2) {
        return ((Person)p1).getId().compareTo(((Person)p2).getId());
    }
}

class SortPersonByFirstName implements Comparator {

    @Override
    public int compare(Object p1, Object p2) {
        return ((Person)p1).getFirstName().compareTo(((Person)p2).getFirstName());
    }
}

class SortPersonByLastName implements Comparator {

    @Override
    public int compare(Object p1, Object p2) {
        return ((Person)p1).getLastName().compareTo(((Person)p2).getLastName());
    }
}

class APIDemo{

    private LinkedList<Person> personsList;

    public void setPersonsList(LinkedList<Person> personsList) {
        this.personsList = personsList;
    }

    public LinkedList<Person> getPersonsList() {
        return this.personsList;
    }

    boolean addPerson(Scanner scan, APIDemo apiRef) {

        LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
        System.out.println("Enter the Person's name :");
        String tempName = scan.nextLine();
        String[] splitName = tempName.split(" ");
        System.out.println("Enter the Person's Id"); 
        int tempId = scan.nextInt();
        scan.nextLine();
        if(tempPersonsList == null) {
            tempPersonsList = new LinkedList<Person>();
            if(splitName.length == 1)
                tempPersonsList.add(new Person(splitName[0],"",tempId));
            else
                tempPersonsList.add(new Person(splitName[0],splitName[1],tempId));
            apiRef.setPersonsList(tempPersonsList);
            return true;
        }
        if(apiRef.internalSearch(tempName,apiRef)){
            return false;
        }
        else {
            if(splitName.length == 1)
                tempPersonsList.add(new Person(splitName[0],"",tempId));
            else
                tempPersonsList.add(new Person(splitName[0],splitName[1],tempId));
            apiRef.setPersonsList(tempPersonsList);
            return true;
        }
        
    }

    boolean deletePerson(Scanner scan, APIDemo apiRef) {

        LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
        System.out.println("Enter the Person's Name you wanna delete from the list");
        String delPersonName = scan.nextLine();
        Person tempPerson = null;
        if(apiRef.internalSearch(delPersonName,apiRef)){
         for(Person person : tempPersonsList) {
            if(person.getName().equals(delPersonName)) {
                tempPerson = person;
                break;
            }
        }
        tempPersonsList.remove(tempPerson);
        apiRef.setPersonsList(tempPersonsList);
        return true; 
    }
    else 
        return false;
}
boolean searchPerson(Scanner scan, APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    System.out.println("Enter the name of the person");
    String tempName = scan.nextLine();
    if(apiRef.internalSearch(tempName,apiRef)){
     for(Person person : tempPersonsList) {
        if(person.getName().equalsIgnoreCase(tempName)) {
            return true;
        }
    }  
}
return false;
}

boolean internalSearch(String searchName, APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    if(tempPersonsList != null) {
     for(Person person : tempPersonsList) {
        if(person.getName().equalsIgnoreCase(searchName)) {
            return true;
        }
    }
}
return false;  
}

void displayPersons(APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    if(tempPersonsList != null) {
        System.out.println("ID Name");
        for(Person person : tempPersonsList) {
            System.out.println(person);
        }
    }
    else {
        System.out.println("Nothing is present in the list");
    }
}

void sortPersonsById(APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    if(tempPersonsList != null) {
        System.out.println("ID Name");
        Collections.sort(tempPersonsList, new SortPersonById());
        for(Person person : tempPersonsList) {
            System.out.println(person);
        }
    }
    else {
        System.out.println("Nothing is present in the list");
    }
}

void sortPersonsByFirstName(APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    if(tempPersonsList != null) {
        System.out.println("ID Name");
        Collections.sort(tempPersonsList, new SortPersonByFirstName());
        for(Person person : tempPersonsList) {
            System.out.println(person);
        }
    }
    else {
        System.out.println("Nothing is present in the list");
    }
}

void sortPersonsByLastName(APIDemo apiRef) {

    LinkedList<Person> tempPersonsList = apiRef.getPersonsList();
    if(tempPersonsList != null) {
        System.out.println("ID Name");
        Collections.sort(tempPersonsList, new SortPersonByLastName());
        for(Person person : tempPersonsList) {
            System.out.println(person);
        }
    }
    else {
        System.out.println("Nothing is present in the list");
    }
}

public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    boolean flag = false;
    APIDemo apidemoRef = new APIDemo();

    do {

        flag = false;
        System.out.println("Enter the action number you wanna take");
        System.out.println("1. Add Person");
        System.out.println("2. Delete Person");
        System.out.println("3. Search Person");
        System.out.println("4. Display Person List ");
        System.out.println("5. Sort Person List By Id");
        System.out.println("6. Sort Person List By First Name");
        System.out.println("7. Sort Person List By Last Name");

        int option = scan.nextInt();
        scan.nextLine();

        switch(option) {

            case 1:

            if(apidemoRef.addPerson(scan,apidemoRef)) {
                System.out.println("Person got added Successfully");
            }
            else {
                System.out.println("There got some error in adding the person");
            }
            break;
            case 2:
            if(apidemoRef.deletePerson(scan,apidemoRef)) {
                System.out.println("Person got deleted Successfully");
            }
            else {
                System.out.println("There got some error in deleting the person");
            }
            break;
            case 3:
            if(apidemoRef.searchPerson(scan,apidemoRef)) {
                System.out.println("Yeah this person exists in the list");
            }
            else {
                System.out.println("this person doesn't exist in the list");
            }
            break;
            case 4:
            apidemoRef.displayPersons(apidemoRef);
            break;
            case 5:
            apidemoRef.sortPersonsById(apidemoRef);
            break;
            case 6:
            apidemoRef.sortPersonsByFirstName(apidemoRef);
            break;
            case 7:
            apidemoRef.sortPersonsByLastName(apidemoRef);
            break;
            default:
            System.out.println("You have enetered wrong option");
            break;
        }

        System.out.println("You wanna continue....Yes/No");
        String consent = scan.nextLine();
        if(consent.equalsIgnoreCase("Yes")) {
            flag = true;
        }
    }while(flag);
}
}