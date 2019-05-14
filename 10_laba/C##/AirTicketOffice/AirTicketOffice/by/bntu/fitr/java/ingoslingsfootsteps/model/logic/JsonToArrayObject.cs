using AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.entity;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace AirTicketOffice.by.bntu.fitr.java.ingoslingsfootsteps.model.logic
{
    class JsonToArrayObject
    {
        private const string PATH_TO_FILE = "D:\\java\\10_laba\\C##\\file.json";

        public static AirTicketOfficeContext DeserializeJson()
        {
            using (StreamReader file = new StreamReader(PATH_TO_FILE))
            {
                var json = file.ReadToEnd();
                return JsonConvert.DeserializeObject<AirTicketOfficeContext>(json);
            }
        }

        public static void SerializeeJson(AirTicketOfficeContext contex)
        {
            using (StreamWriter file = new StreamWriter(PATH_TO_FILE))
            {
                var json = JsonConvert.SerializeObject(contex);
                file.WriteLine(json);
            }
        }
    }
}
