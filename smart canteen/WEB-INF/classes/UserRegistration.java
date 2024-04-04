import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.*;
import java.util.*;
import javax.sql.*;
public class UserRegistration extends HttpServlet {
protected void doPost(HttpServletRequest req, HttpServletResponse res){
PrintWriter out = res.getWriter();
out.println("data entering is started");
String name = req.getParameter("myname");
String password = req.getParameter("password");
String mail = req.getParameter("mail");
String sql = "insert into USER_REGISTRATION(USERNAME,MAIL,PASSWORD)values(?,?,?)";
PreparedStatement stmt = null;
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system"); 
stmt = con.prepareStatement(sql);
stmt.setString(1,name);
stmt.setString(2,mail);
stmt.setString(3,password);
int num = stmt.executeUpdate();
}
catch(Exception e) {
e.printStackTrace();
}
finally {
   
}

}
}
