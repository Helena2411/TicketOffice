package by.bntu.fitr.javalabs.ingosligsfootsteps.view;

import org.apache.log4j.Logger;

public class ConsolePrinter extends Printable {
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger("CONSOLE");
    }

    @Override
    public void print(Object msg) {
        LOG.info(msg);
    }
}
