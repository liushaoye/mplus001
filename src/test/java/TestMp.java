import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * test
 */
public class TestMp {
    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");


    @Test
    public void context() throws SQLException {

        DataSource ds = iocContext.getBean("dataSource", DataSource.class);
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
