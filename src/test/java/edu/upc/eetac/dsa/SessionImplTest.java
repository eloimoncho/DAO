package edu.upc.eetac.dsa;

import org.junit.Before;

public class SessionImplTest {
    Session session;

    @Before
    public void setUp() {
        this.session = FactorySession.openSession("jdbc:mariadb://localhost:3306/crud", "crud", "crud");


    }
}