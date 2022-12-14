package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Pou;
import edu.upc.eetac.dsa.util.ObjectHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ObjectHelperTest {


    @Test
    public void setterTest() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Pou p = new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa");

        ObjectHelper.setter(p, "pouId", "albaseerra");
        ObjectHelper.setter(p, "nombrePou", "Alba");
        ObjectHelper.setter(p, "nacimientoPou", "29/06/2001");
        ObjectHelper.setter(p, "correoPou", "alba@gmail.com");
        ObjectHelper.setter(p, "passwordPou", "africa");


        Assert.assertEquals("albaseerra", p.getPouId());
        Assert.assertEquals("Alba", p.getNombrePou());
        Assert.assertEquals("29/06/2001", p.getNacimientoPou());
        Assert.assertEquals("alba@gmail.com", p.getCorreoPou());
        Assert.assertEquals("africa", p.getPasswordPou());

    }


    @Test
    public void getterTest() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Pou p = new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa" );


        String correoPou = (String) ObjectHelper.getter(p, "correoPou");
        String passwordPou = (String) ObjectHelper.getter(p, "passwordPou");


        Assert.assertEquals("alba@gmail.com", correoPou);
        Assert.assertEquals("africa", passwordPou);
    }

}