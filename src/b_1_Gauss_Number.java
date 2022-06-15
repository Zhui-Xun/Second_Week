// 作业4，数字游戏（类改造后）

import GaussNumber.Game_generate;
import GaussNumber.Number_Compare;

public class b_1_Gauss_Number {
    public static void main(String[] args) {

        // 游戏记录
        boolean EndGame = false;
        int TotalGame = 0;
        int SuccessGame = 0;

        // 正式游戏开始
        while (!EndGame) {

            System.out.println("\n==========================================================");
            // 设置游戏参数
            Game_generate Game = Game_generate.game_generate_init(20, 50, 5);
            // System.out.println("Random = "+Game.Get_NumberToGauss());
            // 正式游戏
            System.out.println("游戏开始，数字范围为：(" + Game.Get_RangeStart() + "," + Game.Get_RangeEnd() + ")，输入-1结束游戏！");
            TotalGame++;

            Number_Compare NewGame = new Number_Compare(Game.Get_NumberToGauss(), Game.Get_Epoch());

            int GameState = NewGame.Gaming(Game.Get_NumberToGauss(), Game.Get_Epoch());

            // 游戏结果记录
            if (GameState < 0) {
                TotalGame--;
                break;
            } else if (GameState == 0) {
                continue;
            } else if (GameState == 1) {
                SuccessGame++;
                continue;
            } else {
                System.out.println("游戏出错！");
                EndGame = true;
            }
        }
        System.out.println("\n========== 共进行" + TotalGame + "轮游戏，成功了" + SuccessGame + "次！==========");
        System.out.println("");
    }
}
