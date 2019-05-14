using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.controller;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util.exception;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.view;
using NLog;
using System;

namespace AirTicketOffice
{
    class Program
    {

        private static readonly Logger logger = LogManager.GetCurrentClassLogger();
        public static void Main(string[] args)
        {
            try
            {
                Printer.print("Hi! What is your name?");
                String name = UserInput.input();
                Printer.print("What is your email?");
                String email = UserInput.input();
                CustomerController customerController = new CustomerController();
                Customer customer = customerController.AddNewCustomerOrGetExisting(name, email);
                FlightController flightController = new FlightController();

                Printer.print("What do you want: 1)book or 2)return ticket?");
                int action = Convert.ToInt32(UserInput.input());
                CustomerAction.ChoicebyCustomer(flightController, customer, action);
            }
            catch (InputException ex)
            {
                Printer.print(($"Error: {ex.Message}"));
                logger.Error($"Error: {ex.Message}");
            }
        }
    }
}
