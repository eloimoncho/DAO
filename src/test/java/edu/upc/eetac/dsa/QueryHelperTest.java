package edu.upc.eetac.dsa;

import edu.upc.eetac.dsa.model.Product;
import edu.upc.eetac.dsa.model.User;
import edu.upc.eetac.dsa.util.QueryHelper;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class QueryHelperTest {

    @Test
    public void testQueryINSERTUser() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("INSERT INTO User (ID, userId, userName, userSurname, processedOrders) VALUES (?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new User("marcmmonfort", "Marc", "Moran")));
    }

    @Test
    public void testQueryINSERTProduct() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Assert.assertEquals("INSERT INTO Product (ID, productId, productName, price, numSales) VALUES (?, ?, ?, ?, ?)",
                QueryHelper.createQueryINSERT(new Product("P001","Camisetas",20.0, 3)));
    }

    @Test
    public void testQuerySELECTUser() {
        Assert.assertEquals("SELECT * FROM User WHERE ID = ?",
                QueryHelper.createQuerySELECT(new User("marcmmonfort", "Marc", "Moran")));
    }

    @Test
    public void testQuerySELECTProduct() {
        Assert.assertEquals("SELECT * FROM Product WHERE ID = ?",
                QueryHelper.createQuerySELECT(new Product("P001","Camisetas",20.0, 3)));
    }

    @Test
    public void testQueryUPDATEUser(){
        Assert.assertEquals("UPDATE User SET userId = ?, userName = ?, userSurname = ?, processedOrders = ? WHERE userId = ?",
                QueryHelper.createQueryUPDATE(new User("albaserra", "Alba", "Serra")));
    }
    @Test
    public void testQueryUPDATEProduct(){
        Assert.assertEquals("UPDATE Product SET productId = ?, productName = ?, price = ?, numSales = ? WHERE productId = ?",
                QueryHelper.createQueryUPDATE(new Product("P001","Camisetas",20.0, 3)));
    }


}
