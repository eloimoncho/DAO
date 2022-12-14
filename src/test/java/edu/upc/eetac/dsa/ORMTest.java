package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Pou;
import edu.upc.eetac.dsa.util.ObjectHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ORMTest {
    Session session;

    @Before
    public void setUp() {
        this.session = FactorySession.openSession("jdbc:mariadb://localhost:3306/crud", "eloim", "YES");


    }

    @Test
    public void registerTest() {

        Pou p = new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa");

        this.session.save(p);

        ///
        // POST ==> hi ha un nou usuari a la taula POU
        //
    }

    @Test
    public void loginTest() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Pou p = new Pou("eloimoncho", "Eloi", "28/08/2001", "eloi@gmail.com", "gnx");
        this.session.save(p);
        Pou pou = (Pou) this.session.get(Pou.class, "albaseerra");
        List<Object> pous = this.session.findAll(Pou.class);
        Assert.assertTrue(ObjectHelper.assertEqual(pou, pous.get(0)));
    }
}