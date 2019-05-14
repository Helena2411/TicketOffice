using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.exception
{
    public class BookingException : Exception
    {
        public BookingException() { }

        public BookingException(string message) : base(message) { }

        public BookingException(string message, Exception inner) : base(message, inner) { }
    }
}
