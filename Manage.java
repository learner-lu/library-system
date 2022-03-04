import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    public void addBookstore() throws SQLException {//�����Ϣ
        Connection conn =Sever.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        System.out.println("�����������Ϣ��");
        Scanner scc = new Scanner(System.in);
        BookManage x = new BookManage();
        System.out.println("�����ţ�");
        String r=scc.next();
        x.setID(r);
        String  sqla= "select * from books where ID ='"+r+"'";
        stmt.execute(sqla);
        if(sqla==null){
            System.out.println("��ͼ�����");
            stmt.close();
        }
        else {
            System.out.println("����ͼ�����ƣ�");
            x.setBname(scc.next());
            System.out.println("�������ߣ�");
            x.setAuthor(scc.next());
            System.out.println("��������磺");
            x.setPublishedHouse(scc.next());
            System.out.println("����ͼ�����ͣ�");
            x.setType(scc.next());
            System.out.println("������λ�ã�");
            x.setPlace(scc.next());
            System.out.println("����������ڣ�");
            x.setDate(scc.next());
            System.out.println();
            try {
                // Statement stmt = (Statement) conn.createStatement();
                String sql = "insert into books values('" + x.getID() + "','"
                        + x.getBname() + "','" + x.getAuthor() + "','" +
                        x.getPublishedHouse() + "','" + x.getType() + "','"
                        + x.getPlace() + "','" + x.getDate() + "','" +
                        x.getBookStatus() + " ',' ',' ',' ',' ');";
                stmt.execute(sql);
                //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                stmt.close();
                System.out.println("��ӳɹ�������");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateBookstore() throws SQLException {//�޸���Ϣ
        Connection con =Sever.getConnection();
        System.out.println("����Ҫ�޸ĵ�ͼ���ţ�");
        BookManage x = new BookManage();
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        Statement stmt = (Statement) con.createStatement();
        String  sqla= "select * from books where ID ='"+r+"'";
        ResultSet resultSet = stmt.executeQuery(sqla);
        // org.apache.commons.collections4.CollectionUtils.isEmpty(Collections.singleton(sqla));
        if(!resultSet.next()){
            System.out.println("��ͼ�鲻����!!");
            stmt.close();}
        else {
            try {
                System.out.println("����ͼ�����ƣ�");
                x.setBname(sc.next());
                System.out.println("�������ߣ�");
                x.setAuthor(sc.next());
                System.out.println("��������磺");
                x.setPublishedHouse(sc.next());
                System.out.println("����ͼ�����ͣ�");
                x.setType(sc.next());
                System.out.println("������λ�ã�");
                x.setPlace(sc.next());
                System.out.println("����������ڣ�");
                x.setDate(sc.next());
                //  System.out.println("�����鼮״̬��");
                // x.setBookStatus(sc.next());
                //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                String sql = "update books set bname='" + x.getBname() + "',author='" + x.getAuthor() + "',publishedHouse='" + x.getPublishedHouse() + "',typel='" + x.getType() + "',place='" + x.getPlace() + "',datel='" + x.getDate() + "',bookStatus='" + x.getBookStatus() + "',borrowPeopleName='" + x.getBorrowPeopleName() + "',numberl='" + x.getNumber() + "',borrowDate='" + x.getBorrowDate() + "',backTime='" + x.getBackTime1() + "' where ID ='" + r + "'";
                System.out.println(" �޸ĳɹ�");
                stmt.execute(sql);
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteBookstore() throws SQLException, ParseException {//ɾ����Ϣ
        Connection conn =Sever.getConnection();
        System.out.println("�������ʱ�䣺");
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        // BookManage bookManage=new BookManage();
        // String time=bookManage.getDate();
        // String timeMax=time+365;

        Statement stmt = (Statement) conn.createStatement();
        String  sqla= "select * from books where datel <'"+r+"'";
        stmt.execute(sqla);
        if(sqla==null){
            System.out.println("��ͼ�鲻����");
            stmt.close();}
        else {
            try {
                //Statement stmt = (Statement) conn.createStatement();
                String sql = "DELETE FROM books WHERE datel <\"" + r + "\"";// ������?��ʾ���൱��ռλ��
                stmt.executeUpdate(sql);
                System.out.println("ɾ���ɹ�");
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void seleteBookstore() throws SQLException {//��ѯ������Ϣ
        Connection conn =Sever.getConnection();
        System.out.println("����Ҫ��ѯ��ͼ�����ƣ�");
        Scanner sc = new Scanner(System.in);
        String r = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        try {
            String sql = "select * from books where bname='"+r+"'";
            ResultSet rs=stmt.executeQuery(sql);
            BookManage bookManage=null;
            while (rs.next()){
                BookManage bookManage1=new BookManage(rs.getString("ID"),rs.getString("bname"),rs.getString("author"),
                        rs.getString("publishedHouse"),rs.getString("typel"),rs.getString("place"),
                        rs.getString("datel"),rs.getString("bookStatus"),rs.getString("borrowPeopleName"),
                        rs.getString("numberl"),rs.getString("borrowDate"), rs.getString("backTime"));
                System.out.println(bookManage1.printBookmassage());
            }
            rs.close();
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void borrowBookStudent1()throws SQLException{
        Connection conn =Sever.getConnection();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        String sql = "select * from student where sname='"+r1+"' and snumber='"+r2+"'";
        ResultSet rs=null;
        rs=stmt.executeQuery(sql);
        if(sql==null) {
            System.out.println("���û�������");
        }
        else {
            {
                System.out.println("������Ҫ���ĵ��鼮��ID��");
                String r4 = sc.next();
                sql = "select * from books where ID='"+r4+"'";
                ArrayList<BookManage> arrayList=new ArrayList<>();
                rs=stmt.executeQuery(sql);
                BookManage x=null;
                while (rs.next()){
                    x=new BookManage(rs.getString("ID"),rs.getString("bname"),rs.getString("author"),
                            rs.getString("publishedHouse"),rs.getString("typel"),rs.getString("place"),
                            rs.getString("datel"),rs.getString("bookStatus"),rs.getString("borrowPeopleName"),
                            rs.getString("numberl"),rs.getString("borrowDate"),rs.getString("backTime"));
                    arrayList.add(x);
                    //rs.close();
                }
                try {
                    if(!x.getType().equals("borrow")) {
                        x.setBorrowDate(x.getBorrowDate1());
                        x.setBookStatus("borrow");
                        x.setBorrowPeopleName(r1);
                        x.setNumber(r2);
                        x.setBackTime("");
                        //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                        sql = "update books set bookStatus='" + x.getBookStatus() + "',borrowPeopleName='" + r1 + "',numberl='" + r2 + "',borrowDate='" + x.getBorrowDate() + "',backTime='" + x.getBackTime() + "'" + " where ID ='" + r4 + "'";
                        stmt.execute(sql);
                        BookManage y = new BookManage(x.getID(), x.getBname(), x.getAuthor(), x.getPublishedHouse(), x.getType(), x.getDate(), r1, r2, x.getBorrowDate(), x.getBackTime());
                        stmt.close();
//
                        try {
                            Statement stat = (Statement) conn.createStatement();
                            String sqlc = "insert into studentborrowmessage values('" + y.getID() + "','" + y.getBname() + "','" + y.getAuthor() + "','" + y.getPublishedHouse() + "','" + y.getType() + "','" + y.getDate() + "','" + y.getBorrowPeopleName() + "','" + y.getNumber() + "','" + y.getBorrowDate() + "','" + y.getBackTime() + "');";
                            stat.executeUpdate(sqlc);
                            //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                            stat.close();
                            System.out.println("���ĳɹ�");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        System.out.println("���ܽ��ģ�������");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void borrowBookTeacher2()throws SQLException{
        Connection conn =Sever.getConnection();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        String sql = "select * from teacher where tname='"+r1+"' and tnumber='"+r2+"'";
        ResultSet rs=stmt.executeQuery(sql);
        if(sql==null) {
            System.out.println("���û�������");
        }
        else {
            {
                System.out.println("������Ҫ���ĵ��鼮��ID��");
                String r4 = sc.next();
                sql = "select * from books where ID='"+r4+"'";
                ArrayList<BookManage> arrayList=new ArrayList<>();
                rs=stmt.executeQuery(sql);
                BookManage x=null;
                while (rs.next()){
                    x=new BookManage(rs.getString("ID"),rs.getString("bname"),rs.getString("author"),
                            rs.getString("publishedHouse"),rs.getString("typel"),rs.getString("place"),
                            rs.getString("datel"),rs.getString("bookStatus"),rs.getString("borrowPeopleName"),
                            rs.getString("numberl"),rs.getString("borrowDate"),rs.getString("backTime"));
                    arrayList.add(x);
                }

                try {
                    if(!x.getType().equals("borrow")) {
                        //  System.out.println("����������ڣ�");
                        x.setBorrowDate(x.getBorrowDate1());
                        x.setBookStatus("borrow");
                        x.setBorrowPeopleName(r1);
                        x.setNumber(r2);
                        x.setBackTime("");
                        //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���

                        sql = "update books set bookStatus='" + x.getBookStatus() + "',borrowPeopleName='" + r1 + "',numberl='" + r2 + "',borrowDate='" + x.getBorrowDate() + "',backTime='" + x.getBackTime() + "'" + " where ID ='" + r4 + "'";
                        stmt.execute(sql);
                        BookManage y = new BookManage(x.getID(),x.getBname(),x.getAuthor(),x.getPublishedHouse(),x.getType(),x.getDate(),r1,r2,x.getBorrowDate(),x.getBackTime());
                        stmt.close();
//
                        try {
                            Statement stat = (Statement) conn.createStatement();
                            String sqlc = "insert into teacherborrowmessage values('"+y.getID() +"','"+y.getBname() +"','"+y.getAuthor() +"','"+y.getPublishedHouse() +"','"+y.getType() +"','"+y.getDate() +"','"+y.getBorrowPeopleName()+"','"+y.getNumber()+"','"+y.getBorrowDate() +"','"+y.getBackTime() +"');";
                            stat.executeUpdate(sqlc);
                            //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                            stat.close();
                            System.out.println("���ĳɹ�");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        System.out.println("���ܽ��ģ�������");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void borrowBookMassage0() throws SQLException{//��ѯ���������Ŀǰ�Ľ������
        Connection conn = Sever.getConnection();
        System.out.println("����Ҫ��ѯ��ͼ�����ƣ�");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        try {
            String sql = "select * from books where bname ='"+r1+"'";
            ResultSet rs = stmt.executeQuery(sql);
            BookManage bookManage = null;
            while (rs.next()) {
                BookManage bookManage1=new BookManage(rs.getString("ID"),rs.getString("bname"),
                        rs.getString("author"),
                        rs.getString("publishedHouse"),rs.getString("typel"),
                        rs.getString("place"),
                        rs.getString("datel"),rs.getString("bookStatus"),
                        rs.getString("borrowPeopleName"),
                        rs.getString("numberl"),rs.getString("borrowDate"),
                        rs.getString("backTime"));
                System.out.println(bookManage1.printBookmassage());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrowBookMassage1() throws SQLException{//ѧ����ѯ���˵Ľ������
        Connection conn = Sever.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String user = sc.next();
        String userid = sc.next();
        try {
            String sql = "select * from studentborrowmessage where borrowPeopleName='"
                    +user+"' and numberl='"+userid+"'";
            ResultSet rs = stmt.executeQuery(sql);
            BookManage bookManage = null;
            //boolean next() throws SQLException
            while (rs.next()) {
                BookManage bookManage1 = new BookManage(rs.getString("ID"),
                        rs.getString("bname"), rs.getString("author"),
                        rs.getString("publishedHouse"), rs.getString("typel"),
                        rs.getString("datel"),rs.getString("borrowPeopleName"),
                        rs.getString("numberl"), rs.getString("borrowDate"),
                        rs.getString("backTime"));
                System.out.println(bookManage1.printBookBorrowmassage());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void borrowBookMassage2() throws SQLException{//��ʦ��ѯ���˵Ľ������
        Connection conn = Sever.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        try {
            String sql = "select * from teacherborrowmessage where borrowPeopleName='"+r1+"' and numberl='"+r2+"'";
            ResultSet rs = stmt.executeQuery(sql);
            BookManage bookManage = null;
            while (rs.next()) {
                BookManage bookManage1 = new BookManage(rs.getString("ID"), rs.getString("bname"), rs.getString("author"),
                        rs.getString("publishedHouse"), rs.getString("typel"), rs.getString("datel"),rs.getString("borrowPeopleName"),rs.getString("numberl"),
                        rs.getString("borrowDate"), rs.getString("backTime"));
                System.out.println(bookManage1.printBookBorrowmassage());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backBookStudent1()throws SQLException{
        Connection conn =Sever.getConnection();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        String sql = "select * from student where sname='"+r1+"' and snumber='"+r2+"'";
        stmt.executeQuery(sql);
        if(sql==null) {
            System.out.println("���û�������");
        }
        else {
            System.out.println("������Ҫ�黹���鼮��");
            String r3 = sc.next();
            String sqla="select * from books where bname='"+r3+"'";
            stmt.executeQuery(sqla);
            if(sqla==null) {
                System.out.println("��ͼ�鲻����");
            }
            else {
                BookManage x = new BookManage();
                System.out.println("������Ҫ�黹���鼮��ID��");
                String r4 = sc.next();
                try {
                    Statement stat = (Statement) conn.createStatement();
                    sql= "select * from studentborrowmessage where ID='"+r4+"'" ;
                    ResultSet rs=null;
                    rs=stmt.executeQuery(sql);
                    BookManage y=null;
                    while (rs.next()) {
                        // BookManage bookManage=null;
                        //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                        y = new BookManage(rs.getString("ID"), rs.getString("bname"), rs.getString("author"),
                                rs.getString("publishedHouse"), rs.getString("typel"), rs.getString("datel"), rs.getString("borrowPeopleName"), rs.getString("numberl"),
                                rs.getString("borrowDate"), rs.getString("backTime"));
                    }    //rs.close();
                    Statement stab = (Statement) conn.createStatement();
                    String sqlx = "insert into studentbackmessage values('"+y.getID() +"','"+y.getBname()
                            +"','"+y.getAuthor() +"','"+y.getPublishedHouse()
                            +"','"+y.getType() +"','"+y.getDate() +"','"+y.getBorrowPeopleName()
                            +"','"+y.getNumber()+"','"+y.getBorrowDate() +"','"+y.getBackTime1() +"');";
                    stat.executeUpdate(sqlx);
                    stab.close();


                }
                catch (Exception e){
                    e.printStackTrace();
                }
                try {
                    // System.out.println("����黹���ڣ�");
                    x.setBackTime(x.getBackTime1());
                    x.setBookStatus("");
                    x.setBorrowPeopleName("");
                    x.setNumber("");
                    x.setBorrowDate("");

                    sql = "update books set bookStatus='" + x.getBookStatus() + "',borrowPeopleName='"
                            + x.getBorrowPeopleName() + "',numberl='" + x.getNumber()
                            + "',borrowDate='" + x.getBorrowDate() + "',backTime='" + x.getBackTime1() + "'" + " where ID ='" + r4 + "'";
                    stmt.execute(sql);

                    //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���

                    //  BookManage y = new BookManage(x.getID(), x.getBname(), x.getAuthor(), x.getPublishedHouse(), x.getType(), x.getDate(),x.getBorrowPeopleName(),x.getNumber(), x.getBorrowDate(), x.getBackTime());
                    stmt.close();
                    try {
                        Statement stme = (Statement) conn.createStatement();
                        String sqld="DELETE FROM studentborrowmessage WHERE ID='"+r4+"'";// ������?��ʾ���൱��ռλ��
                        stme.executeUpdate(sqld);
                        stme.close();
                        System.out.println("�黹�ɹ�");
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void backBookTeacher2()throws SQLException{
        Connection conn =Sever.getConnection();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        Statement stmt = (Statement) conn.createStatement();
        String sql = "select * from teacher where tname='"+r1+"' and tnumber='"+r2+"'";
        // ResultSet rs=stmt.executeQuery(sql);
        if(sql.length()==0||sql==null) {
            System.out.println("���û�������");
        }
        else {
            System.out.println("������Ҫ�黹���鼮��");
            String r3 = sc.next();
            String sqla="select * from books where bname='"+r3+"'";
            stmt.executeQuery(sqla);
            if(sqla.length()==0||sql==null) {
                System.out.println("��ͼ�鲻����");
            }
            else {
                BookManage x = new BookManage();
                System.out.println("������Ҫ�黹���鼮��ID��");
                String r4 = sc.next();
                try {
                    Statement stat = (Statement) conn.createStatement();
                    sql= "select * from teacherborrowmessage where ID='"+r4+"'" ;
                    ResultSet rs=null;
                    rs=stmt.executeQuery(sql);
                    BookManage y=null;
                    while (rs.next()) {
                        y = new BookManage(rs.getString("ID"), rs.getString("bname"), rs.getString("author"),
                                rs.getString("publishedHouse"), rs.getString("typel"), rs.getString("datel"), rs.getString("borrowPeopleName"), rs.getString("numberl"),
                                rs.getString("borrowDate"), rs.getString("backTime"));
                        Statement stab = (Statement) conn.createStatement();
                        String sqlx = "insert into teacherbackmessage values('" + y.getID() + "','"
                                + y.getBname() + "','" + y.getAuthor()
                                + "','" + y.getPublishedHouse() + "','" + y.getType()
                                + "','" + y.getDate() + "','" + y.getBorrowPeopleName() + "','"
                                + y.getNumber() + "','" + y.getBorrowDate() + "','" + y.getBackTime1() + "');";
                        stat.executeUpdate(sqlx);
                        stab.close();
                    }

                    try {
                        // System.out.println("����黹���ڣ�");
                        x.setBackTime(x.getBackTime1());
                        x.setBookStatus("");
                        x.setBorrowPeopleName("");
                        x.setNumber("");
                        x.setBorrowDate("");

                        sql = "update books set bookStatus='" + x.getBookStatus() + "',borrowPeopleName='" +
                                x.getBorrowPeopleName() + "',numberl='" + x.getNumber() + "',borrowDate='"
                                + x.getBorrowDate() + "',backTime='" + x.getBackTime1() + "'" + " where ID ='" + r4 + "'";
                        stmt.execute(sql);

                        //  ������?��ʾ���൱��ռλ����Ȼ���ڶԲ������и�ֵ��������ִ��ʱ����Щ�����������SQL����У���SQL���ƴ��������ȥִ�С������ͻ���ٶ����ݿ�Ĳ���
                        //  BookManage y = new BookManage(x.getID(), x.getBname(), x.getAuthor(), x.getPublishedHouse(), x.getType(), x.getDate(),x.getBorrowPeopleName(),x.getNumber(), x.getBorrowDate(), x.getBackTime());
                        stmt.close();

                        try {
                            Statement stme = (Statement) conn.createStatement();
                            String sqld="DELETE FROM teacherborrowmessage WHERE ID='"+r4+"'";// ������?��ʾ���൱��ռλ��
                            stme.executeUpdate(sqld);
                            stme.close();
                            System.out.println("�黹�ɹ�");
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

        }


    }

    public void backBookMassage1() throws SQLException{//ѧ����ѯ���˵Ľ������
        Connection conn = Sever.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        try {
            String sql = "select * from studentBackMessage where borrowPeopleName='"+r1+"' and numberl='"+r2+"'";
            ResultSet rs =null;
            rs=stmt.executeQuery(sql);
            BookManage bookManage = null;
            while (rs.next()) {
                BookManage  bookManage1 = new BookManage(rs.getString("ID"),
                        rs.getString("bname"), rs.getString("author"),
                        rs.getString("publishedHouse"), rs.getString("typel"),
                        rs.getString("datel"),rs.getString("borrowPeopleName"),
                        rs.getString("numberl"), rs.getString("borrowDate"),
                        rs.getString("backTime"));
                System.out.println(bookManage1.printBookBackmassage());
        }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backBookMassage2() throws SQLException{//��ʦ��ѯ���˵Ľ������
        Connection conn = Sever.getConnection();
        Statement stmt = (Statement) conn.createStatement();
        System.out.println("�������û�����ID��");
        Scanner sc = new Scanner(System.in);
        String r1 = sc.next();
        String r2 = sc.next();
        try {
            String sql = "select * from teacherbackmessage";
            //  String sql = "select * from teacherbackmessage where borrowPeopleName='"+r1+"' and numberl='"+r2+"'";
            ResultSet rs =null;
            rs=stmt.executeQuery(sql);
            //ArrayList<BookManage> arrayList = new ArrayList<>();
            BookManage bookManage1 = null;
            while (rs.next()) {
                bookManage1 = new BookManage(rs.getString("ID"), rs.getString("bname"), rs.getString("author"),
                        rs.getString("publishedHouse"), rs.getString("typel"), rs.getString("datel"),rs.getString("borrowPeopleName"),rs.getString("numberl"),
                        rs.getString("borrowDate"), rs.getString("backTime"));
                System.out.println(bookManage1.printBookBackmassage());
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookSort()throws SQLException{//����
        Connection conn =Sever.getConnection();
        System.out.println("��ͼ����������");
        try {
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books ORDER BY CONVERT(bname USING GB2312)");
            while (rs.next()){
                BookManage bookManage1=new BookManage(rs.getString("ID"),rs.getString("bname"),rs.getString("author"),
                        rs.getString("publishedHouse"),rs.getString("typel"),rs.getString("place"),
                        rs.getString("datel"),rs.getString("bookStatus"),rs.getString("borrowPeopleName"),
                        rs.getString("numberl"),rs.getString("borrowDate"), rs.getString("backTime"));
                System.out.println(bookManage1.printBookmassage());
            }
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void show() {
        Connection conn =Sever.getConnection();
        try {
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from books");
            while (rs.next()) {
                BookManage bookManage1 = new BookManage(rs.getString("ID"),
                        rs.getString("bname"), rs.getString("author"),
                        rs.getString("publishedHouse"), rs.getString("typel"),
                        rs.getString("place"), rs.getString("datel"),
                        rs.getString("bookStatus"), rs.getString("borrowPeopleName"),
                        rs.getString("numberl"), rs.getString("borrowDate"),
                        rs.getString("backTime"));
                System.out.println(bookManage1.printBookmassage());
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
