/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer_system;

/**
 *
 * @author DW
 */
public class Customer {
     // Data Fields
    
    public String name;
    public int contract_id;
    public String nationality;
    public String phone;
    public double current_bill;
    public double accumulated_bill;
    
    // Constructor
    public Customer(String name, int contract_id, String nationality, String phone, double current_bill, double accumulated_bill) {
        this.name = name;
        this.contract_id = contract_id;
        this.nationality = nationality;
        this.phone = phone;
        this.current_bill = current_bill;
        this.accumulated_bill = accumulated_bill;
    }

    Customer(String name, String nationalit, String phone, double current_bill, double accumulated_bill, int contract_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Setters (Update)
    public void set_name(String new_name) {
        this.name = new_name;
    }

    public void set_contract_id(int new_id) {
        this.contract_id = new_id;
    }

    public void set_nationality(String new_nationality) {
        this.nationality = new_nationality;
    }

    public void set_phone(String new_phone) {
        this.phone = new_phone;
    }

    public void set_current_bill(double new_bill) {
        this.current_bill = new_bill;
        this.accumulated_bill += this.current_bill;
    }

    // Getters
    public String get_name() {
        return this.name;
    }

    public int get_contract_id() {
        return this.contract_id;
    }

    public String get_phone() {
        return this.phone;
    }

    // compareTo() Method
    public boolean compareTo(Customer second_customer) {
        return this.name.compareTo(second_customer.name) > 0;
    }

    // toString() Method
    public String toString() {
        return  contract_id + "\t\t\t" +
                name + "\t" +
                phone + "\t" +
                nationality + "\t" +
                current_bill + "\t\t\t" +
                accumulated_bill;
    }

    // line() Method
    public String line() {
        return  contract_id + "-" +
                name + "-" +
                phone + "-" +
                nationality + "-" +
                current_bill + "-" +
                accumulated_bill;
    }

    // equals() Method
    public boolean equals(Object second_customer) {
        Customer pointer = (Customer) second_customer;

        return  this.name.equals(pointer.name) &&
                this.contract_id == pointer.contract_id &&          // Only this enough, Because contract ID is UNIQUE
                this.nationality.equals(pointer.nationality) &&
                this.phone.equals(pointer.phone);
    }

    // header() Method
    public static String header() {
        return  "Contract ID\tName\tPhone\t\tNationality\tCurrent Bill\tAccumulated Bill";
    }
}
