package GaussNumber;
import java.util.Scanner;

public class Number_Compare {

    private int NumToGauss;
    private int LeftEpoch;

    public Number_Compare(int NumToGauss,int Epoch){
        this.NumToGauss = NumToGauss;
        this.LeftEpoch = Epoch;
    }

    public int Gaming(int NumToGauss,int Epoch) {

        Scanner in = new Scanner(System.in);
        this.NumToGauss = NumToGauss;
        this.LeftEpoch = Epoch;
        int GameState = 0; // 定义游戏的状态，-1表示结束，0表示失败，1表示成功。

        // 游戏开始
        while (LeftEpoch > 0) {
            System.out.println("请输入猜测数字：");
            // 读入用户输入
            int Gauss = in.nextInt();

            // 判断是否结束游戏
            if (Gauss < 0) {
                System.out.println("用户选择结束游戏！");
                GameState = -1;
                break;
            }
            LeftEpoch--;
            if (Gauss < NumToGauss) {
                System.out.println("输入数字比目标数\"小\"！\t剩余" + LeftEpoch + "次机会！");
            } else if (Gauss > NumToGauss) {
                System.out.println("输入数字比目标数\"大\"！\t剩余" + LeftEpoch + "次机会！");
            } else {
                System.out.println("输入正确！");
                System.out.println("恭喜，游戏成功！");
                System.out.println("此轮游戏结束");
                GameState = 1;
                break;
            }
            if (LeftEpoch == 0) {
                System.out.println("很遗憾，此轮游戏失败！");
                GameState = 0;
            }
        }
        System.out.println("==========================================================");
        return GameState; // 返回游戏状态
    }
}
