import org.postgresql.copy.CopyManager; 
import org.postgresql.core.BaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Sever {
    // ���ݿ�����·��
    private static final String driver = "org.postgresql.Driver";
    private static final  String url = "jdbc:postgresql://119.3.178.237:5432/postgres";
    //URLָ��Ҫ���ʵ����ݿ���
    private static final  String user = "lzx";
    //MySQL����ʱ���û���
    private static final String password = "07-hsluzx";
    //MySQL����ʱ������
    private static Connection con = null;
    // ��̬����飨�������������������ݿ���뾲̬���У�
    static{
        try {
            Class.forName(driver); // ������������
            System.out.println("try to connect");
            con = DriverManager.getConnection(url, user, password); // ��ȡ���ݿ������
            System.out.println("connection ok");
        }
        catch (SQLException ex) {
            while (ex != null) {
                ex = ex.getNextException();
            }
        }
        catch (Exception ce) {
            ce.printStackTrace();
        }
    }
    // �����ṩһ����������ȡ���ݿ�����

    public static Connection getConnection(){
        return con;
    }
}
