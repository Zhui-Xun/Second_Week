// ��ҵ����AIС����

import AI.ai_define;
import java.util.Scanner;

public class a_3_Qusetion_and_Answer {
    public static void main(String[] args) {
        ai_define AI = new ai_define();
        Scanner scanner = new Scanner(System.in);

        System.out.println("���ʿ������ܰ棬��ʾ������\"exit\"�˳��ʴ�");
        System.out.println("�ʴ�ʼ���������������:");
        while (true){
            String question = scanner.next();
            if ("exit".equals(question)){
                System.out.println("�ʴ������");
                break;
            }

            // �ʴ����
            String answer = AI.Answer(question);
            System.out.println(answer);

        }
    }
}
