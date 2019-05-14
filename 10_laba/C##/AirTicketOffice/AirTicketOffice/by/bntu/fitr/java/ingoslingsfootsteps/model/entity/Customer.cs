using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity
{
    public class Customer
    {
        private string name;
        private string id;
        private string email;

        public Customer()
        {
            this.name = "no name";
            this.email = "no email";
            this.id = Guid.NewGuid().ToString("N");
        }

        public Customer(string name, string email)
        {
            this.name = name;
            this.email = email;
        }

        public Customer(Customer customer) : this(customer.name, customer.email) { }

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }

        public string Email
        {
            get
            {
                return email;
            }
            set
            {
                email = value;
            }
        }

        public string Id
        {
            get
            {
                return id;
            }
            set
            {
                id = value;
            }
        }

        public override string ToString()
        {
            return "Name='" + name + ", email = " + email;
        }
    }

}
