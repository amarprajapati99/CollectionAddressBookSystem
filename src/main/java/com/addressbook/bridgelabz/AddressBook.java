package com.addressbook.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

/*
@Description - To create a contacts in address book with first name, last name, address, city, state,
* zip,mobile number.
* Added a new contact in address book.
* added multiple contact in address book.
 */
public class AddressBook {
    ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
    Contacts contacts;
    static Scanner scanner = new Scanner(System.in);
    private void addNewContacts() {
        System.out.println("enter the first name");
        String firstName = scanner.nextLine();
        System.out.println("enter the last name");
        String lastName = scanner.nextLine();
        System.out.println("enter the address");
        String address = scanner.nextLine();
        System.out.println("enter the state");
        String state = scanner.nextLine();
        System.out.println("enter the city");
        String city = scanner.nextLine();
        System.out.println("enter the zip code");
        int zipCode = scanner.nextInt();
        System.out.println("enter the mobile number");
        long number = scanner.nextLong();
        System.out.println("enter email-id");
        String email = scanner.next();
        contacts = new Contacts(firstName, lastName, address, state, city, zipCode, number, email);
        System.out.println("contact successfully added");
        contactsList.add(contacts);
    }
    /* to check duplicate entry if find duplicate are not allowed */
    public boolean duplicateEntryCheck(String firstName)
    {
        for (Contacts contacts: contactsList) {
            boolean existAlready=contacts.equals(firstName);
            if(existAlready==true)
                return true;
        }
        return false;
    }
    /* @Description - in this we edit contacts details
    * addse multiple contacts in address book
    * @Parameter - to take first name by user to check first name is matching or not if the name matched we can perform the
    * edit details, delete details etc*/

    public void editContactDetails(String firstName) {
        if (contactsList.isEmpty())
            System.out.println("Address book is empty");
        else {
            int dic = contactsList.size();
            int i;
            for (i = 0; i < contactsList.size(); i++) {
                if (contactsList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                    System.out.println("what do  you want to edit");
                    System.out.println("select 1 -> To edit the first name");
                    System.out.println("select 2 -> To edit the last name");
                    System.out.println("select 3 -> To edit the address");
                    System.out.println("select 4 -> To edit the state");
                    System.out.println("select 5 -> To edit the city");
                    System.out.println("select 6 -> To edit the zip code");
                    System.out.println("select 7 -> To edit the mobile number");
                    System.out.println("select 8 -> To edit eamil-id");
                    System.out.println("enter your choice");
                    Scanner scanner = new Scanner(System.in);
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("enter the first name");
                            contactsList.get(i).setFirstName(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        case 2:
                            System.out.println("enter the last name");
                            contactsList.get(i).setLastName(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        case 3:
                            System.out.println("enter address");
                            contactsList.get(i).setAddress(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        case 4:
                            System.out.println("enter the state");
                            contactsList.get(i).setState(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        case 5:
                            System.out.println("enter the city");
                            contactsList.get(i).setCity(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        case 6:
                            System.out.println("enter the zipcode");
                            contactsList.get(i).setZip(scanner.nextInt());
                            System.out.println("Contact successfully updated");
                            break;
                        case 7:
                            System.out.println("enter mobile number");
                            contactsList.get(i).setMobileNumber(scanner.nextLong());
                            System.out.println("Contact successfully updated");
                            break;
                        case 8:
                            System.out.println("enter the email-id");
                            contactsList.get(i).setEmailId(scanner.next());
                            System.out.println("Contact successfully updated");
                            break;
                        default:
                            System.out.println("enter the correct choice");
                            break;
                    }
                    break;
                }
            }
            if (dic == i)
                System.out.println("contact not found");
        }
    }
    /* @Description delete contacts details if first name is matched.
    * searching by first name and to delete contacts details */
    public void deleteContact(String firstName) {
        if (contactsList.isEmpty())
            System.out.println("Address book is empty");
        else {
            int d = contactsList.size();
            int i;
            for (i = 0; i < contactsList.size(); i++) {
                if (contactsList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                    Contacts contacts = contactsList.get(i);
                    contacts = null;
                    contactsList.remove(i);
                    System.out.println("contact deletd successfully");
                    break;
                }
            }
            if (d == i)
                System.out.println("contact is not found in address book");
        }
    }
    @Override
    public String toString(){
        if (contactsList.isEmpty())
            return "Address book is empty";
        else {
            for (int i = 0; i < contactsList.size(); i++) {
                System.out.println(i + 1 + ". " + contactsList.get(i).toString());
            }
        }
        return "";
    }
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        int choice = 0;
        while (choice != 5) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("what you want to do please select 1-5 ");
            System.out.println("select  1 -> To add a new contact in the address book");
            System.out.println("select 2 -> To edit the existing contact");
            System.out.println("select 3 -> To delete the existing contact");
            System.out.println("select 4 -> To print the Address Book");
            System.out.println("select 5 -> To exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addNewContacts();
                    break;
                case 2:
                    System.out.println("enter the first name of contact you want to edit");
                    addressBook.editContactDetails(scanner.next());
                    break;
                case 3:
                    System.out.println("enter the first name of contact you want to delete");
                    addressBook.deleteContact(scanner.next());
                    break;
                case 4:
                    System.out.println(addressBook.toString());
                    break;
                case 5:
                    System.exit(choice);
                default:
                    System.out.println("press correct choice number");
            }
        }
    }
}
