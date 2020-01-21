package snowfall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for the SnowfallLogger
class SnowfallLoggerTest {
    SnowfallLogger l1;
    SnowfallLogger l2;

    @BeforeEach
    void runBefore() {
     l1 = new SnowfallLogger();
     l2 = new SnowfallLogger();
    }

    @Test
    void testConstructor() {
        assertEquals(0, l1.getNumSnowfallRecords());
        assertEquals(0, l1.getAverageSnowfall());
        assertEquals(0, l1.getNumSnowDays());
    }

    @Test
    void testAddSingleSnowfallRecord() {
        l1.addSnowfallRecord(16);
        assertEquals(16, l1.record);
        l2.addSnowfallRecord(14);
        assertEquals(14, l2.record);

    }

    @Test
    void testAddMultipleSnowfallRecords() {
        l1.addSnowfallRecord(16);
        l1.addSnowfallRecord(14);
        assertEquals(30, l1.record);
        l2.addSnowfallRecord(12);
        l2.addSnowfallRecord(11);
        assertEquals(23, l2.record);

    }

    @Test
    void testNumSnowDays() {
        l1.addSnowfallRecord(16);
        l1.addSnowfallRecord(14);
        l1.addSnowfallRecord(15);
        assertEquals(3,l1.day);
        assertEquals(2,l1.snowDay);
        l2.addSnowfallRecord(12);
        l2.addSnowfallRecord(11);
        l2.addSnowfallRecord(10);
        assertEquals(3,l2.day);
        assertEquals(0,l2.snowDay);
    }

    @Test
    void testReset() {
        l1.addSnowfallRecord(16);
        l1.addSnowfallRecord(14);
        l1.addSnowfallRecord(15);
        l1.reset();
        assertEquals(0, l1.record);
        assertEquals(0,l1.day);
        assertEquals(0,l1.snowDay);
    }

    @Test
    void testGetAverageSnowfall(){
        l1.addSnowfallRecord(16);
        l1.addSnowfallRecord(14);
        l1.addSnowfallRecord(17);
        assertEquals(47.0 / 3.0, l1.getAverageSnowfall());

    }

}