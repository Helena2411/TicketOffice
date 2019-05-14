using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util.exception;
using NLog;
using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic
{
    public class CustomerController
    {
        private static readonly Logger logger = LogManager.GetCurrentClassLogger();

        private static AirTicketOfficeContext context;

        public CustomerController()
        {
            context = AirTicketOfficeContext.Context;
        }

        public Customer AddNewCustomerOrGetExisting(string name, string email)
        {
            if (name.Equals("") || email.Equals(""))
                throw new InputException("You entered the incorrect data");
            Customer customer;
            for (int i = 0; i < context.Customers.Length; i++)
            {
                if (email.Equals(context.GetCustomerByIndex(i).Email))
                {
                    customer = context.GetCustomerByIndex(i);
                    logger.Info("Got existing customer");
                    return customer;
                }
            }
            customer = new Customer(name, email);
            context.AddCustomer(customer);
            logger.Info("Added new customer in json");
            return customer;
        }
    }
}
