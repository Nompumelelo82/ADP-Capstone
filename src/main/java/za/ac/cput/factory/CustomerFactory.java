package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(String customerId,
                                          String customerName,
                                          String phoneNumber, String email ,String address){

        if(Helper.isEmptyOrNull(customerId) ||
           Helper.isEmptyOrNull(customerName) ||
           Helper.isEmptyOrNull(phoneNumber) ||
           Helper.isEmptyOrNull(address))
        {
            return null;

        }

        if(!Helper.isValidEmail(email)){
            return null;
        }


        return new Customer.Builder()
                .setCustomerId(customerId)
                .setCustomerName(customerName)
                .setPhoneNumber(phoneNumber)
                .setEmail(email)
                .setAddress(address)
                .build();

    }

}
