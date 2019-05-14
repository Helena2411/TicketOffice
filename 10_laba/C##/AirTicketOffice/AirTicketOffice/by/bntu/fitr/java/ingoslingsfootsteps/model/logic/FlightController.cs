using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.exception;
using NLog;
using NLog.Fluent;
using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic
{
    public class FlightController
    {
        private static readonly Logger logger = LogManager.GetCurrentClassLogger();

        private static AirTicketOfficeContext context;

        public FlightController()
        {
            context = AirTicketOfficeContext.Context;
        }

        public AirTicketOfficeContext GetAvailableFlight(Customer customer)
        {
            AirTicketOfficeContext availableFlight = new AirTicketOfficeContext();

            for (int i = 0; i < context.Flights.Length; i++)
            {
                bool isEmpty = true;
                string[] customersId = context.GetFlightByIndex(i).CustomersId;
                 if (context.GetFlightByIndex(i).CustomersId.Length == 0)
                {
                    availableFlight.Flights = AddFlightToArray(availableFlight, i).Flights;
                    isEmpty = false;
                }
                for (int j = 0; j < context.GetFlightByIndex(i).CustomersId.Length; j++)
                {
                    if (customer.Id.Equals(customersId[j]))
                    {
                        isEmpty = false;
                    }
                }
                if (isEmpty)
                {
                    availableFlight.Flights = AddFlightToArray(availableFlight, i).Flights;
                }
            }
            if (availableFlight.Flights.Length == 0)
            {
                throw new BookingException("You haven't available flight. Sorry(");
            }
            logger.Info("Got list of available flights");
            return availableFlight;
        }

        public AirTicketOfficeContext GetFlightsBookedByCustomer(Customer customer)
        {
            AirTicketOfficeContext occupiedCars = new AirTicketOfficeContext();
            for (int i = 0; i < context.SizeOfFlight(); i++)
            {
                String[] customersId = context.GetFlightByIndex(i).CustomersId;
                if (context.GetFlightByIndex(i).CustomersId.Length == 0)
                    continue;
                for (int j = 0; j < context.GetFlightByIndex(i).CustomersId.Length; j++)
                {
                    if (customer.Id.Equals(customersId[j]))
                    {
                        occupiedCars.Flights = AddFlightToArray(occupiedCars, i).Flights;
                        break;
                    }
                }
            }
            if (occupiedCars.Flights.Length == 0)
            {
                throw new BookingException("You haven't booked flight.");
            }
            logger.Info("Got list of booked by customer flights");
            return occupiedCars;
        }
        private AirTicketOfficeContext AddFlightToArray(AirTicketOfficeContext airTicketOfficeContext, int index)
        {
            Flight[] flights = airTicketOfficeContext.Flights;
            Array.Resize(ref flights, flights.Length + 1);
            flights[flights.Length - 1] = context.GetFlightByIndex(index);
            airTicketOfficeContext.Flights = flights;
            return airTicketOfficeContext;
        }

        public void BookTicket(Flight flight, Customer customer)
        {
            flight.AddCustomersId(customer);
            logger.Info("Data saved");
            context.SaveChanges();
        }

        public void ReturnTicket(Flight flight, Customer customer)
        {
            string[] customersId = flight.CustomersId;
            for (int i = 0; i < customersId.Length; i++)
            {
                if (customer.Id.Equals(customersId[i]))
                {
                    flight.RemoveCustomerId(i);
                }
            }
            logger.Info("Data saved");
            context.SaveChanges();
        }
    }
}
