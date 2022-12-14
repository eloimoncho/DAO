package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Pou;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QueryHelperTest {

    @Test
    public void testQueryINSERTUser() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("INSERT INTO Pou (pouId, nombrePou, nacimientoPou, correoPou, passwordPou) VALUES (?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Pou("marcmmonfort", "Marc", "28/10/2001", "marc@gmail.com", "calella")));
    }

    @Test
    public void testQuerySELECTUser() {
        Assert.assertEquals("SELECT * FROM Pou WHERE pouId = ?",
                QueryHelper.createQuerySELECT(new Pou("marcmmonfort", "Marc", "28/10/2001", "marc@gmail.com", "calella")));
    }

    @Test
    public void testQueryUPDATEUser(){
        Assert.assertEquals("UPDATE Pou SET pouId = ?, nombrePou = ?, nacimientoPou = ?, correoPou = ?, passwordPou = ? WHERE pouId = ?",
                QueryHelper.createQueryUPDATE(new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa")));
    }



}
