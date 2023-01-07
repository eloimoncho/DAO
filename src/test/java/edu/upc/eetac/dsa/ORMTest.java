package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.ObjetoArmario;
import edu.upc.eetac.dsa.model.ObjetoTienda;
import edu.upc.eetac.dsa.model.Pou;
import edu.upc.eetac.dsa.util.ObjectHelper;
import edu.upc.eetac.dsa.util.QueryHelper;
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

        //

    }

    @Test
    public void registerTest() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        /*
        Pou p = new Pou("palancasFC", "Laporta", "30/01/2001", "palancas@gmail.com", "bcn");

        ObjetoTienda o = new ObjetoTienda("RC001","Camiseta blanca",6,"Ropa",0,0,0,0);

        ObjetoArmario a = new ObjetoArmario(4,"eloimoncho","Bebida","B001",3);

        this.session.save(p);
        this.session.save(o);
        this.session.save(a);

         */

    }

    @Test
    public void findAllTest(){

        List<Pou> pous = (List<Pou>)this.session.findAll(Pou.class);
        Assert.assertEquals("1", pous.get(0).getNombrePou());
        Assert.assertEquals(6, pous.size());
        List<ObjetoArmario> armarios = (List<ObjetoArmario>) this.session.findAll(ObjetoArmario.class);
        Assert.assertEquals(6, armarios.size());
        List<ObjetoTienda> objetos = (List<ObjetoTienda>) this.session.findAll(ObjetoTienda.class);
        Assert.assertEquals(7, objetos.size());
    }

    @Test
    public void loginTest() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Pou pou = (Pou) this.session.get(Pou.class, "albaseerra");
        Assert.assertEquals("albaseerra",pou.getPouId());
    }

    @Test
    public void updateTest(){
        Pou pou = new Pou("albaseerra", "Alba", "29/06/2001", "alba@gmail.com", "africa");
        pou.setDineroPou(50);
        pou.setNivelHambrePou(20);
        pou.setCamisetaId("RC001");
        pou.setNivelSuenoPou(30);
        this.session.update(pou);
    }

    @Test
    public void deleteTest(){
        Pou pou = new Pou("eloimoncho", "Eloi", "28/08/2001", "eloi@gmail.com", "gnx");
        this.session.delete(pou);
    }

    @Test
    public void getElementosTest(){

        List<ObjetoArmario> lista = (List<ObjetoArmario>) this.session.getElementos(ObjetoArmario.class, "pouId","albaseerra");

        Assert.assertEquals(3,lista.size());
        Assert.assertEquals("C001",lista.get(0).getIdArticulo());
        Assert.assertEquals(1,lista.get(1).getIdArmario());


        List<Pou> listaPous = (List<Pou>) this.session.getElementos(Pou.class, "record", "100");
        Assert.assertEquals(1, listaPous.size());
        Assert.assertEquals("victorfernandez", listaPous.get(0).getPouId());

        List<ObjetoTienda> listaObjetos = (List<ObjetoTienda>) this.session.getElementos(ObjetoTienda.class,"tipoArticulo", "Bebida");
        Assert.assertEquals("B001", listaObjetos.get(0).getArticuloId());
        Assert.assertEquals(2,listaObjetos.size());
    }
}