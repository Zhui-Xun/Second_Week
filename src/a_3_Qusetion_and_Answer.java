// 作业三，AI小程序

import AI.ai_define;
import java.util.Scanner;

public class a_3_Qusetion_and_Answer {
    public static void main(String[] args) {
        ai_define AI = new ai_define();
        Scanner scanner = new Scanner(System.in);

        System.out.println("快问快答非智能版，提示：输入\"exit\"退出问答。");
        System.out.println("问答开始，请输入你的问题:");
        while (true){
            String question = scanner.next();
            if ("exit".equals(question)){
                System.out.println("问答结束！");
                break;
            }

            // 问答程序
            String answer = AI.Answer(question);
            System.out.println(answer);

        }
    }
}
