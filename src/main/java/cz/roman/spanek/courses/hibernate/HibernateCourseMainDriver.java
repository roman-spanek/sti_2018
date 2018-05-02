package cz.roman.spanek.courses.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class HibernateCourseMainDriver {
	private static Logger logger = Logger.getLogger(HibernateCourseMainDriver.class);
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/rdb_2018";
    static final String USER = "rdb_2018";
    static final String PASS = "rdb_2018";
    
    
    
    
    public static void main(String[] args) {
    	logger.info("Starting app");        
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
        	Class.forName(JDBC_DRIVER);

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Omezeni";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_omezeni = rs.getInt("id_omezeni");
                int km_omzeni = rs.getInt("km_omzeni");
                int prujezdnost = rs.getInt("prujezdnost");
                System.out.print("id_omezeni" + id_omezeni);
                System.out.print(", km_omzeni: " + km_omzeni);
                System.out.println(", prujezdnost: " + prujezdnost);
            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
        
        
    	 /*
         System.out.println("load context");
         ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         
         
         
         SilniceService silniceServise = (SilniceService)context.getBean("silniceServise");
         Silnice silnice = silniceServise.findById("D1");
         System.out.println("Found one Silnice:"+silnice.getCisloSilnice());
         */
         /*
         GenericEmployeeService emService = (GenericEmployeeService) context.getBean("genericServiceEmployee");
         Employee employee = emService.findById(1);
         System.out.println("Found one employee:"+employee.getName() + " - "+employee.getAge());
         */
         
        /*
         System.out.println(em.getName());
         context.close();
         */
    }

}
