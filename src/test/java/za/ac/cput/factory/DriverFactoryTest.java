
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Driver;
import static org.junit.jupiter.api.Assertions.*;

public class DriverFactoryTest {
    @Test
    void testBuildDriver_Success() {
        Driver driver = DriverFactory.buildDriver(
                "Peter", "Burger", "LIC123456", "0821234567", true);
        assertNotNull(driver);
        assertEquals("Peter", driver.getFirstName());
        assertEquals("Burger", driver.getLastName());
        assertEquals("LIC123456", driver.getLicenseNumber());
        assertEquals("0821234567", driver.getPhoneNumber());
        assertTrue(driver.isAvailability());
        assertNotNull(driver.getId());
    }

    @Test
    void testBuildDriver_IdIsUnique() {
        Driver d1 = DriverFactory.buildDriver("Jane", "Smith", "LIC999", "0839876543", false);
        Driver d2 = DriverFactory.buildDriver("Jane", "Smith", "LIC999", "0839876543", false);
        assertNotEquals(d1.getId(), d2.getId());
    }
}