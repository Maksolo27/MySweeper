package test;

import Sweeper.Coord;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by maxim on 24.04.2021.
 */
public class Tests {

    @BeforeClass
    public static void init() {
        Coord coord = new Coord(0,0);
        System.out.println("Init test");
    }

    @AfterClass
    public static void end() {
        System.out.println("Test over");
    }

    @Test
    public void listTest(){
        Coord coord1 = new Coord(1,1);
        Coord coord2 = new Coord(1,1);
        boolean equal = coord1.equals(coord2);
        if(!equal){
            Assert.fail();
        }
    }
}
