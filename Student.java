public class Student {
    private String sname;//ѧ������
    private String snumber;//ѧ��

    public Student(){
        String sname="";//ѧ������
        String snumber="";//ѧ��
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSname() {
        return sname;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }
    public String getSnumber() {
        return snumber;
    }

    public void printStudentMassage(){
        System.out.println();
        System.out.println("������   "+getSname()+"ѧ�ţ�   "+getSnumber());
    }
}
