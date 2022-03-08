package Framework;

import java.util.Arrays;
import java.util.Iterator;

public class iterateurDe implements Iterator<De> {
    private Iterator<De> lstDe;
    public iterateurDe(De[] nvlstDe){
        lstDe = Arrays.stream(nvlstDe).iterator();
    }
    @Override
    public boolean hasNext() {
        while (lstDe.hasNext()){
            return true;
        }
        return false;
    }

    @Override
    public De next() {
        return lstDe.next();
    }
}
