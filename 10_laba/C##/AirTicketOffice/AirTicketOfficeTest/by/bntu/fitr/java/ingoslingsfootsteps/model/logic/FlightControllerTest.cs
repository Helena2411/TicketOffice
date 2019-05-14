using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.exception;

namespace AirTicketOfficeTest.by.bntu.fitr.java.ingoslingsfootsteps.model.logic
{
    class FlightControllerTest
    {
        [Test]
        public void getAvailableFlightOfNewCustomerByLength()
        {
            CustomerController customerController = new CustomerController();
            Customer customer = customerController.AddNewCustomerOrGetExisting("Ivan", "ivan_ivanov");
            FlightController flightController = new FlightController();
            AirTicketOfficeContext context = AirTicketOfficeContext.Context;
            AirTicketOfficeContext availableFlight = flightController.GetAvailableFlight(customer);
            Assert.AreEqual(availableFlight.Flights.Length, context.SizeOfFlight());
        }

        [Test]
        public void getAvailableFlightOfExistingCustomerByLength()
        {
            CustomerController customerController = new CustomerController();
            int isActual = 1;
            Customer customer = customerController.AddNewCustomerOrGetExisting("Matvey", "matvey_anisovich");
            FlightController flightController = new FlightController();
            AirTicketOfficeContext availableFlight = flightController.GetAvailableFlight(customer);
            Assert.AreEqual(availableFlight.Flights.Length, isActual);
        }

        [Test]
        public void notAvailableFlight()
        {
            CustomerController customerController = new CustomerController();
            Customer customer = customerController.AddNewCustomerOrGetExisting("Helena", "lenka_bokshic");
            FlightController flightController = new FlightController();
            Assert.Throws<BookingException>(() => flightController.GetAvailableFlight(customer));
        }

        [Test]
        public void notTicketBookedByCustomer()
        {
            CustomerController customerController = new CustomerController();
            Customer customer = customerController.AddNewCustomerOrGetExisting("Ivan", "ivan_ivanov");
            FlightController flightController = new FlightController();
            Assert.Throws<BookingException>(() => flightController.GetFlightsBookedByCustomer(customer));
        }

        [Test]
        public void getTicketsBookedExistingCustomerByLength()
        {
            CustomerController customerController = new CustomerController();
            int isActual = 2;
            Customer customer = customerController.AddNewCustomerOrGetExisting("Helena", "lenka_bokshic");
            FlightController flightController = new FlightController();
            AirTicketOfficeContext availableFlight = flightController.GetFlightsBookedByCustomer(customer);
            Assert.AreEqual(availableFlight.Flights.Length, isActual);
        }
    }
}
