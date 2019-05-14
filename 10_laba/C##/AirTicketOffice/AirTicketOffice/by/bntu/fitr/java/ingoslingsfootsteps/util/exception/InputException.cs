using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util.exception
{
    public class InputException : Exception
    {
        public InputException() { }

        public InputException(string message) : base(message) { }

        public InputException(string message, Exception inner) : base(message, inner) { }
    }
}
