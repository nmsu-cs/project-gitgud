
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class NMSUEZPARKingTests 
{
   // Data you need for each test case


   //
   // Method to search for a given aggieID in user_data.txt, and return a user objct with that aggieID's given values.
   // If the given aggieID could not be found in the .txt file, returns null instead.
   //
   public static User findUser(String aggieID) throws IOException {
      User foundUser = new User();
      FileReader fRead = new FileReader("user_data.txt");
      BufferedReader read = new BufferedReader(fRead);

      do {
         String data = read.readLine();
         String[] data2 = data.split(",");
         if(data2[0].equals(aggieID)) {
            foundUser.setAggieID(aggieID);
            foundUser.setFullName(data2[1]);
            foundUser.setHasParkingPermit(Boolean.valueOf(data2[2]));
            foundUser.setParkingPermitType(data2[3]);
            foundUser.setCurrentParkAt(data2[4]);
            foundUser.setCurrentParkNumAt(Integer.valueOf(data2[5]));
            read.close();
            return foundUser;
         }
      } while(!read.equals(null));

      //If the loop finishes, then all users were searched and the specified number was not found.
      read.close();
      return null;

   }


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
      try {
         User testUser = new User(findUser("000000001").getAggieID(), findUser("000000001").getFullName(), findUser("000000001").getHasParkingPermit(), findUser("000000001").getParkingPermitType(), findUser("000000001").getCurrentParkAt(), findUser("000000001").getCurrentParkNumAt());
         assertFalse(testUser.getHasParkingPermit());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


   //
   // Test a user who has a North Residential Parking permit.
   //
   @Test
   public void userNorthResident()
   {
      try {
         User testUser = findUser("000000011");
         assertTrue(testUser.getHasParkingPermit());
         assertTrue(testUser.getParkingPermitType().equals("North Residential Parking (Yellow)"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }


   //
   // Test a user who has a Commuter Parking permit.
   //
   @Test
   public void userCommuter()
   {
      try {
         User testUser = findUser("000000021");
         assertTrue(testUser.getHasParkingPermit());
         assertTrue(testUser.getParkingPermitType().equals("Commuter Permit (Green)"));
      } catch (IOException e) {
         e.printStackTrace();
      }  
   }


   //
   // Test a user who has a Commuter Parking permit.
   //
   @Test
   public void userFaculty()
   {
      try {
         User testUser = findUser("000000031");
         assertTrue(testUser.getHasParkingPermit());
         assertTrue(testUser.getParkingPermitType().equals("Faculty Parking (Maroon)"));
      } catch (IOException e) {
         e.printStackTrace();
      }  
   }

}