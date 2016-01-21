package com.wrap.backend;

import com.wrap.backend.constant.Action;
import com.wrap.backend.constant.Deteminer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DeterminerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DeterminerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DeterminerTest.class );
    }

    /**
     * test stand off
     */
    public void testStandOff()
    {
    	for(int i = 0;i<5;i++){
    		assertEquals(Deteminer.play(i, i), Action.standoff);
    	}
    }
}
