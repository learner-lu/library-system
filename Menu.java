import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws Exception {
        Manage manage=new Manage();
        Mbin a=new Mbin();
        // a.printMbin();
        System.out.println("1.����Ա��¼  2.ѧ����¼  3.��ʦ��¼");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if(select==1){
                System.out.println("����Ա��¼�ɹ���");
                while (true) {
                    a.printMbina();
                    String selects = scanner.next();
                    switch (selects) {
                        case "a": {
                            manage.addBookstore(); //���ͼ��
                            System.out.println();
                        }
                        break;
                        case "b": {
                            manage.updateBookstore(); //�޸�ͼ��
                            System.out.println();
                        }
                        break;
                        case "c": {
                            manage.deleteBookstore(); //ɾ��ͼ��
                            System.out.println();
                        }
                        break;
                        case "d": {
                            manage.seleteBookstore(); //��ѯͼ��
                            System.out.println();
                        }
                        break;
                        case "e": {
                            manage.show();  //�鼮������Ϣ��ѯ
                            System.out.println();
                        }
                        break;
                        case "g": {
                            manage.borrowBookMassage0();  //�鼮������Ϣ��ѯ
                            System.out.println();
                        }
                        break;
                        case "f": {
                            manage.bookSort();
                            System.out.println();  //�鼮����
                        }
                        break;
                        default:
                            System.out.println("ѡ����� �ر�ϵͳ����");
                            System.exit(0);
                    }
                }
            }
            else if(select==2){
                System.out.println("ѧ����¼�ɹ���");
                while (true) {
                    a.printMbinb();
                    String selects = scanner.next();
                    switch (selects) {
                        case "a": {
                            manage.seleteBookstore();//��ѯͼ��
                            System.out.println();
                        }
                        break;
                        case "b": {
                            manage.borrowBookStudent1();//ѧ������
                            System.out.println();
                        }
                        break;
                        case "c": {
                            manage.borrowBookMassage0(); //�鼮���Ĳ�ѯ
                            System.out.println();
                        }
                        break;
                        case "d": {
                            manage.borrowBookMassage1();//ѧ�����Ĳ�ѯ
                            System.out.println();
                        }
                        break;
                        case "e": {
                            manage.backBookStudent1();//����
                            System.out.println();
                        }
                        break;
                        case "f": {
                            manage.backBookMassage1();//ѧ���黹��ѯ
                            System.out.println();
                        }
                        break;
                        default:
                            System.out.println("ѡ������˳�ϵͳ������");
                            System.exit(0);
                    }
                }
            }
            else if(select==3){
                System.out.println("��ʦ��¼�ɹ���");
                while (true) {
                    a.printMbinc();
                    String selects = scanner.next();
                    switch (selects) {
                        case "a":{
                            manage.seleteBookstore();
                            System.out.println();
                        }
                        break;
                        case "b": {
                            manage.borrowBookTeacher2();
                            System.out.println();
                        }
                        break;
                        case "c": {
                            manage.borrowBookMassage0();
                            System.out.println();
                        }
                        break;
                        case "d": {
                            manage.borrowBookMassage2();
                            System.out.println();
                        }
                        break;
                        case "e": {
                            manage.backBookTeacher2();
                            System.out.println();
                        }
                        break;
                        case "f": {
                            manage.backBookMassage2();
                            System.out.println();
                        }
                        break;
                        default:
                            System.out.println("ѡ������˳�ϵͳ������");
                            System.exit(0);
                    }
                }
            }else{
                System.out.println("��ݴ��󣡣�����");
            }
        }
    }
}
