package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.ObjetoArmario;
import edu.upc.eetac.dsa.model.ObjetoTienda;
import edu.upc.eetac.dsa.model.Pou;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QueryHelperTest {

    @Test
    public void testQueryINSERTPou() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("INSERT INTO Pou (pouId, nombrePou, nacimientoPou, correoPou, passwordPou, " +
                        "dineroPou, nivelHambrePou, nivelSaludPou, nivelDiversionPou, nivelSuenoPou, camisetaId, pantalonId, gorraId, gafasId)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Pou("marcmmonfort", "Marc", "28/10/2001", "marc@gmail.com", "calella")));
    }

    @Test
    public void testQuerySELECTPou() {
        Assert.assertEquals("SELECT * FROM Pou WHERE pouId = ?",
                QueryHelper.createQuerySELECT(new Pou("marcmmonfort", "Marc", "28/10/2001", "marc@gmail.com", "calella")));
    }

    @Test
    public void testQueryUPDATEPou(){
        Assert.assertEquals("UPDATE Pou SET pouId = ?, nombrePou = ?, nacimientoPou = ?, correoPou = ?, passwordPou = ?, " +
                        "dineroPou = ?, nivelHambrePou = ?, nivelSaludPou = ?, nivelDiversionPou = ?, nivelSuenoPou = ?, camisetaId = ?, pantalonId = ?, gorraId = ?, gafasId = ? " +
                        "WHERE pouId = ?",
                QueryHelper.createQueryUPDATE(new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa")));
    }

    @Test
    public void testQueryDELETEPou(){
        Assert.assertEquals("DELETE FROM Pou WHERE pouId = ?",
                QueryHelper.createQueryDELETE(new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa")));
    }

    @Test
    public void testQuerySELECTAll(){
        Assert.assertEquals("SELECT * FROM Pou", QueryHelper.createQuerySelectAll(Pou.class));
        Assert.assertEquals("SELECT * FROM ObjetoTienda", QueryHelper.createQuerySelectAll(ObjetoTienda.class));
        Assert.assertEquals("SELECT * FROM ObjetoArmario", QueryHelper.createQuerySelectAll(ObjetoArmario.class));
    }
    @Test
    public void testQuerySELECTElementos(){
        Pou p = new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa");
        ObjetoTienda o = new ObjetoTienda("C002","Patatas",5,"Comida",10,0,0,0);
        String parametro1 = "nivelSalud";
        String parametro2 = "tipoArticulo";
        Assert.assertEquals("SELECT * FROM Pou WHERE nivelSalud = ?",
                QueryHelper.createQuerySELECTElementos(p.getClass(), parametro1));
        Assert.assertEquals("SELECT * FROM ObjetoTienda WHERE tipoArticulo = ?",
                QueryHelper.createQuerySELECTElementos(o.getClass(), parametro2));
    }

}
