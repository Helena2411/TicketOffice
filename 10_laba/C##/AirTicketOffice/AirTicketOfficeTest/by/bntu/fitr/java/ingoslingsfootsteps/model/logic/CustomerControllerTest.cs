using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic;
using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.util.exception;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace AirTicketOfficeTest.by.bntu.fitr.java.ingoslingsfootsteps.model.logic
{
    [TestFixture]
    class CustomerControllerTest
    {
        [Test]
        public void addNewCustomerOrGetExisting() {
            CustomerController customerController = new CustomerController();
           Assert.Throws<InputException>(()=>customerController.AddNewCustomerOrGetExisting("", ""));
        }

        [Test]
        public void getExistingCustomerByEmail() {
            Customer isActual = new Customer("Helena", "lenka_bokshic");
            CustomerController customerController = new CustomerController();
            Customer expected = customerController.AddNewCustomerOrGetExisting(isActual.Name, isActual.Email);
            Assert.AreEqual(expected.Email, isActual.Email);
        }

        [Test]
        public void getExistingCustomerByName() {
            Customer isActual = new Customer("Helena", "lenka_bokshic");
            CustomerController customerController = new CustomerController();
            Customer expected = customerController.AddNewCustomerOrGetExisting(isActual.Name, isActual.Email);
            Assert.AreEqual(expected.Name, isActual.Name);
        }

        [Test]
        public void addNewCustomer() {
            Customer isActual = new Customer("Ivan", "Ivanov");
            CustomerController customerController = new CustomerController();
            Customer expected = customerController.AddNewCustomerOrGetExisting(isActual.Name, isActual.Email);
            Assert.AreEqual(expected.Name, isActual.Name);
        }
    }
}
