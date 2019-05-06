package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.view;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Flight;
import org.apache.log4j.Logger;

public class Printer {
    private static final Logger LOG;
    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.view.Printer.class);
    }

    public static void printArray(Object[] objects) {
        for (int i = 0; i < objects.length; i++)
        {
            System.out.print(i + 1 + " ");
            System.out.println(objects[i]);
            LOG.info(objects[i]);
        }
    }
    public static void print(Object object)
    {
        System.out.println(object);
        LOG.info(object);
    }
}
