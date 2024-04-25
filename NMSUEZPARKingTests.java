
import static org.junit.jupiter.api.Assertions.*;
import java.beans.Transient;
import org.junit.jupiter.api.*;

public class NMSUEZPARKingTests
{
   // Data you need for each test case
   private User testUser;


   @BeforeEach
   public void setup()
   {
      System.out.println("\nTest starting...");
   }


   @AfterEach
   public void teardown()
   {
      System.out.println("\nTest finished.");
   }

   //
   // Test a user who has no parking permit.
   //
   @Test
   public void userNoPermit()
   {
      testUser = new User("000000001", "Smib Flib", false, "", "", 0);
      assertFalse(testUser.getHasParkingPermit());
   }


   //
   // Test a user who has a North Residential Parking permit.
   //
   @Test
   public void userNorthResident()
   {
      testUser = new User("000000001", "Smip Flip", true, "North Residential Parking (Yellow)", "", 0);
   }

}