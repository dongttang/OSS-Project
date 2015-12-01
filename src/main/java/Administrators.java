import java.util.ArrayList;
import java.util.Scanner;

public class Administrators extends CommonStaitcMethod{

    private static ArrayList<Administrator> alist;
    private final String adminID[] = {"2009", "20103308", "20113300"};
    private final String password[] = {"dlaehdgns", "rlatjdrhs", "dbsaudtlr"};

    private Administrators(){
        alist = new ArrayList<>();
        for(int i=0; i<adminID.length; i++)
            alist.add(new Administrator(adminID[i],password[i]));
    }

    public static final boolean checkAdmin() {

        Administrators admins = new Administrators();

        boolean check = true;
        boolean exist = false;
        boolean loop = true;
        while(loop) {

            System.out.print("관리자 학번을 입력해주세요 : ");
            String tempID = inputString();

            for (int i = 0; i < alist.size(); i++) {
                if (tempID.equals(alist.get(i).adminID)) {
                    System.out.println(alist.get(i).adminID);
                    exist = true;
                    loop = false;
                    int count = 3;
                    while (count > 0) {
                        System.out.print("비밀번호를 입력해주세요 : ");
                        String tempPassword = inputString();
                        if (tempPassword.equals(alist.get(i).adminPassword)) {
                            check = true;
                            break;
                        } else {
                            System.out.println("잘못된 비밀번호 입니다.");
                            count--;
                            System.out.println("남은 입력횟수 : " + count);
                            check = false;
                        }
                    }
                }
            }

            if(exist == false){
                check = false;
                System.out.println("1.다시입력");
                System.out.println("종료하려면 아무거나 누르십시오");
                int tempInt = inputInt();
                if(tempInt == 1)
                    loop = true;
                else
                    loop = false;
            }
        }
        return check;
    }
}
