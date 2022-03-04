import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookManage {
    //ͼ����Ϣ
    private String ID;//���
    private String bname;//ͼ������
    private String author;//����
    private String publishedHouse;//������
    private String type;//ͼ������
    private String place;//���λ��
    private String date;//��������
    private String bookStatus;//�鼮״̬
    private String borrowPeopleName;//������
    private String number;//������Id
    private String borrowDate;//��������
    private String backTime;//�黹����

    public BookManage(){
        String ID=" ";//���
        String bname=" ";//ͼ������
        String author=" ";//����
        String publishedHouse=" ";//������
        String type=" ";//ͼ������
        String place=" ";//���λ��
        String date=" ";//��������
        String bookStatus=" ";//�鼮״̬
        String borrowPeopleName=" ";//������
        String number=" ";//������Id
        String borrowDate=" ";//��������
        String backTime=" ";//�黹����
    }
    public BookManage(String ID, String bname,String author,String publishedHouse,String type,String date,String borrowPeopleName, String number,String borrowDate,String backTime) {
        this.ID=ID;//���
        this.bname=bname;//ͼ������
        this.author=author;//����
        this.publishedHouse=publishedHouse;//������
        this.type=type;//ͼ������
        this.date=date;//��������
        this.borrowPeopleName=borrowPeopleName;//������
        this.number=number;//������Id
        this.borrowDate=borrowDate;//��������
        this.backTime=backTime;//�黹����
    }
    public BookManage(String ID, String bname,String author,String publishedHouse,String type,String place,String date,String bookStatus,String borrowPeopleName, String number,String borrowDate,String backTime){
        this.ID=ID;//���
        this.bname=bname;//ͼ������
        this.author=author;//����
        this.publishedHouse=publishedHouse;//������
        this.type=type;//ͼ������
        this.place=place;//���λ��
        this.date=date;//��������
        this.bookStatus=bookStatus;//�鼮״̬
        this.borrowPeopleName=borrowPeopleName;//������
        this.number=number;//������Id
        this.borrowDate=borrowDate;//��������
        this.backTime=backTime;//�黹����
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getID() {
        return ID;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
    public String getBname() {
        return bname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public void setPublishedHouse(String publishedHouse) {
        this.publishedHouse = publishedHouse;
    }
    public String getPublishedHouse() {
        return publishedHouse;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    public String getPlace() {
        return place;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }
    public String getBookStatus() {
        return bookStatus;
    }

    public void setBorrowPeopleName(String borrowPeopleName) {
        this.borrowPeopleName = borrowPeopleName;
    }
    public String getBorrowPeopleName() {
        return borrowPeopleName;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber() {
        return number;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }
    public String getBackTime1() {
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        backTime = dateFormat.format(calendar.getTime());
        return backTime;
    }
    public String getBackTime(){
        return backTime;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }
    public String getBorrowDate1() {
        DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        borrowDate = dateFormat.format(calendar.getTime());
        return borrowDate;
    }
    public String getBorrowDate() {
        return borrowDate;
    }

    //ͼ��������Ϣ���
    public String printBookAllmassage() {
        return "BookManage{" + "ID='" + ID + '\'' + ", bname='" + bname + '\'' + ", author='" + author + '\'' + ", publishedHouse='" + publishedHouse + '\'' + ", type='" + type + '\'' + ", place='" + place + '\'' + ", date='" + date + '\'' + ", bookStatus='" + bookStatus + '\'' + ", borrowPeopleName='" + borrowPeopleName + '\'' + ", number='" + number + '\'' + ", borrowDate='" + borrowDate + '\'' + ", backTime='" + backTime + '\'' + '}';
    }


    //ͼ�������Ϣ���
    public String printBookmassage() {
        return "BookManage{" + "ID='" + ID + '\'' + ", bname='" + bname + '\'' + ", author='" + author + '\'' + ", publishedHouse='" + publishedHouse + '\'' + ", type='" + type + '\'' + ", place='" + place + '\'' + ", date='" + date + '\'' + ", bookStatus='" + bookStatus + '\'' + '}';
    }


    //�鼮������Ϣ���
    public String printBookBorrowmassage() {
        return "BookManage{" + "ID='" + ID + '\'' + ", bname='" + bname + '\'' + ", author='" + author + '\'' + ", publishedHouse='" + publishedHouse + '\'' + ", type='" + type + '\'' + ", date='" + date + '\'' + ", borrowDate='" + borrowDate + '\'' + ", backTime='" + backTime + '\'' + '}';
    }

    //�鼮�黹��Ϣ���
    public String printBookBackmassage() {
        return "BookManage{" + "ID='" + ID + '\'' + ", bname='" +
                bname + '\'' + ", author='" + author + '\'' + ", publishedHouse='"
                + publishedHouse + '\'' + ", type='" + type + '\'' + ", date='" + date +
                '\'' + ", borrowDate='" + borrowDate + '\'' + ", backTime='" + backTime + '\'' + '}';
    }

}
