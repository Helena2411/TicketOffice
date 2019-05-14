using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic;
using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity
{
    public class AirTicketOfficeContext
    {
        private static AirTicketOfficeContext context;

        private Flight[] flights;
        private Customer[] customers;

        public AirTicketOfficeContext()
        {
            this.flights = new Flight[0];
            this.customers = new Customer[0];
        }

        public AirTicketOfficeContext(Flight[] flights, Customer[] customers)
        {
            this.flights = flights;
            this.customers = customers;
        }

        public AirTicketOfficeContext(AirTicketOfficeContext airTicketOfficeContex) : this(airTicketOfficeContex.flights, airTicketOfficeContex.customers)
        {

        }

        public Flight[] Flights
        {
            get
            {
                return flights;
            }
            set
            {
                flights = value;
            }
        }

        public Customer[] Customers
        {
            get
            {
                return customers;
            }
            set
            {
                customers = value;
            }
        }

        public static AirTicketOfficeContext Context
        {
            get
            {
                if (context == null)
                    context = JsonToArrayObject.DeserializeJson();
                return context;
            }
            set
            {
                context = value;
            }
        }

        public int SizeOfFlight()
        {
            return flights.Length;
        }

        public int SizeOfCustomers()
        {
            return customers.Length;
        }

        public void AddCustomer(Customer customer)
        {
            Array.Resize(ref customers, customers.Length + 1);
            this.customers[customers.Length - 1] = customer;
        }

        public Customer GetCustomerByIndex(int index)
        {
            return customers[index];
        }

        public Flight[] GetFlights()
        {
            return flights;
        }
        public void SetFlights(Flight[] flights)
        {
            this.flights = flights;
        }

        public void SetCustomerByIndex(int index, Customer customer)
        {
            customers[index] = customer;
        }

        public void SetFlightByIndex(int index, Flight flight)
        {
            flights[index] = flight;
        }

        public Flight GetFlightByIndex(int index)
        {
            return flights[index];
        }

        public void SaveChanges()
        {
            JsonToArrayObject.SerializeeJson(context);
        }
        public override string ToString()
        {
            StringBuilder planesOfAirbase = new StringBuilder();
            int n = 1;
            foreach (var flight in flights)
            {
                planesOfAirbase.Append(n).Append(". ").Append(flight.ToString()).Append("\n");
                n++;
            }
            return planesOfAirbase.ToString();
        }
    }
}
