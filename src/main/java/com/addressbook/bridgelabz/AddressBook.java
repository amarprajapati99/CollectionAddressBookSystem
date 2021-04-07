package com.addressbook.bridgelabz;

import java.util.Scanner;

/*
@Description - To create a contacts in address book with first name, last name, address, city, state,
* zip,mobile number.
* Added a new contact in address book.
 */
public class AddressBook {
    Contacts contacts;
    static Scanner scanner = new Scanner(System.in);
    private void addContacts() {
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
    }
    /* @Description - in this we edit contacts details  */

    public void editContactDetails(String firstName) {
        if (contacts == null)
            System.out.println("Address book is empty");
        else {
            if (contacts.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("edit the contact details");
                Scanner scanner = new Scanner(System.in);
                System.out.println("enter the first name");
                contacts.setFirstName(scanner.next());
                System.out.println("enter the last name");
                contacts.setLastName(scanner.next());
                System.out.println("enter address");
                contacts.setAddress(scanner.next());
                System.out.println("enter the state");
                contacts.setState(scanner.next());
                System.out.println("enter the city");
                contacts.setCity(scanner.next());
                System.out.println("enter the zipcode");
                contacts.setZip(scanner.nextInt());
                System.out.println("enter mobile number");
                contacts.setMobileNumber(scanner.nextLong());
                System.out.println("enter the email-id");
                contacts.setEmailId(scanner.next());

                System.out.println("Contact successfully updated");
            } else
                System.out.println("contact not found");
        }
    }
    /* @Description delete contacts details if first name is matched. */
    public void deleteContact(String firstName) {
        if (contacts == null)
            System.out.println("Address book is empty");
        else {
            if (contacts.getFirstName().equalsIgnoreCase(firstName)) {
                contacts = null;
                System.out.println("contact deletd successfully");
            } else
                System.out.println("contact is not found in address book");

        }
    }
    @Override
    public String toString(){
        if (contacts == null)
            return "Address book is empty";
        else
            return contacts.toString();
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContacts();
        System.out.println("enter the first name of contact you wanna  edit");
        addressBook.editContactDetails(scanner.next());
        System.out.println(addressBook.toString());
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
                    addressBook.addContacts();
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
