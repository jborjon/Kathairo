package edu.byui.theawesomes.kathairo2;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * Created by fmcho on 6/8/2016.
 */
public class CrossWordTest extends ApplicationTestCase<Application> {
    public CrossWordTest() {
        super(Application.class);
    }


    public void testGetNumber()throws Exception{
        MainActivity test = new MainActivity();
        assertNotNull(test.getNumber());
    }

    public void testSetUserName() throws Exception {
        MainActivity test = new MainActivity();
        String username = "Joseph";
        assertTrue(test.setUserName(username));

    }


}