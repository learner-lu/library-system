public class Teacher {
    private String tname;//��ʦ����
    private String tnumber;//����
    //BookManage tbook;//ͼ��ʹ����Ϣ

    public Teacher(){
        String tname="";//��ʦ����
        String tnumber="";//����
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
    public String getTname() {
        return tname;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }
    public String getTnumber() {
        return tnumber;
    }

    public void printTeacherMassage(){
        System.out.println();
        System.out.println("������   "+getTname()+"���ţ�   "+getTnumber());

    }
}
