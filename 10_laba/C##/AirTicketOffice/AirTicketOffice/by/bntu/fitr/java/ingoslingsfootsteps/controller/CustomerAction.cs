using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.exception;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util.exception;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.view;
using NLog;
using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.controller
{
    public class CustomerAction
    {
        private static readonly Logger logger = LogManager.GetCurrentClassLogger();

        public static void ChoicebyCustomer(FlightController flightController, Customer customer, int action)
        {
            try
            {
                if (action == 1)
                {
                    AirTicketOfficeContext availableFlight = flightController.GetAvailableFlight(customer);
                    Printer.print(availableFlight.ToString());
                    Printer.print("Choose flight");
                    int index = Convert.ToInt32(UserInput.input());
                    flightController.BookTicket(availableFlight.Flights[index - 1], customer);
                    logger.Info("Ticket is booked");
                }
                else if (action == 2)
                {
                    AirTicketOfficeContext occupiedCars = flightController.GetFlightsBookedByCustomer(customer);
                    Printer.print(occupiedCars.ToString());
                    Printer.print("Choose flight");
                    int index = Convert.ToInt32(UserInput.input());
                    flightController.ReturnTicket(occupiedCars.Flights[index - 1], customer);
                    logger.Info("Ticket is booked");
                }
                else
                {
                    throw new InputException("You should enter 1 or 2");
                }
            }
            catch (Exception ex)
            {
                if (ex is BookingException || ex is InputException)
                {
                    System.Console.WriteLine($"Error: {ex.Message}");
                }
                logger.Error(ex.Message);
            }
        }
    }

}
