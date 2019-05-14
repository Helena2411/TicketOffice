using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity
{
    public class Flight
    {
        private const int MIN_COUNT_OF_TICKETS = 400;
        private const int MIN_PRICE = 100;

        private string departurePoint;
        private string destination;
        private string departureDate;
        private string departureTime;
        private int countOfTicket;
        private int price;
        private string[] customersId;

        public Flight()
        {
            departurePoint = "no name";
            destination = "no name";
            departureDate = "no name ";
            departureTime = "no name";
            countOfTicket = MIN_COUNT_OF_TICKETS;
            price = MIN_PRICE;
        }

        public Flight(String departurePoint, String destination, String departureDate, String departureTime, int countOfTicket, int price)
        {
            this.departurePoint = departurePoint;
            this.destination = destination;
            this.departureDate = departureDate;
            this.departureTime = departureTime;
            this.countOfTicket = countOfTicket;
            this.price = price;
        }

        public Flight(Flight flight) : this(flight.departurePoint, flight.destination, flight.departureDate, flight.departureTime, flight.countOfTicket, flight.price)
        {
        }

        public string DeparturePointame
        {
            get
            {
                return this.departurePoint;
            }
            set
            {
                this.departurePoint = value;
            }
        }

        public string Destination
        {
            get
            {
                return this.destination;
            }
            set
            {
                this.destination = value;
            }
        }

        public string DepartureDate
        {
            get
            {
                return this.departureDate;
            }
            set
            {
                this.departureDate = value;
            }
        }

        public string DepartureTime
        {
            get
            {
                return this.departureTime;
            }
            set
            {
                this.departureTime = value;
            }
        }

        public int CountOfTicket
        {
            get
            {
                return this.countOfTicket;
            }
            set
            {
                this.countOfTicket = value;
            }
        }

        public int Price
        {
            get
            {
                return this.price;
            }
            set
            {
                this.price = value;
            }
        }

        public string[] CustomersId
        {
            get
            {
                return this.customersId;
            }
            set
            {
                this.customersId = value;
            }
        }

        public void AddCustomersId(Customer customer)
        {
            Array.Resize(ref this.customersId, this.customersId.Length + 1);
            this.customersId[this.customersId.Length - 1] = customer.Id;
        }

        public void RemoveCustomerId(int index)
        {
            int size = this.customersId.Length;
            String[] newCustomersEmail = new String[size - 1];
            System.Array.Copy(this.customersId, 0, newCustomersEmail, 0, index);
            System.Array.Copy(this.customersId, index + 1, newCustomersEmail, index,
                    size - index - 1);
            this.customersId = new String[newCustomersEmail.Length];
            System.Array.Copy(newCustomersEmail, 0, this.customersId, 0, newCustomersEmail.Length);
        }

        public override string ToString()
        {
            return departurePoint + " ---> " + destination + ", Date - " + departureDate + ", Time - " + departureTime
                    + ", Price - " + price;
        }
    }
}
