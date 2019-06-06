package by.bntu.fitr.javalabs.ingosligsfootsteps.view;

import org.apache.log4j.Logger;

public class FilePrinter extends Printable {
    private static final Logger LOG;

    static {
        LOG = Logger.getLogger("FILE");
    }

    @Override
    public void print(Object msg) {
        LOG.info(msg);
    }
}
