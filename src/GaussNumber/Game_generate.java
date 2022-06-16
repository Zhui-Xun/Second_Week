package GaussNumber;

public class Game_generate {

    // 游戏参数
    private int RangeStart;
    private int RangeEnd;
    private int Epoch;
    private int NumberToGauss;

    // 构造方法
    private Game_generate(int RangeStart, int RangeEnd, int Epoch, int NumberToGauss) {
    //public Game_generate(int RangeStart, int RangeEnd, int Epoch, int NumberToGauss) {
        this.RangeStart = RangeStart;
        this.RangeEnd = RangeEnd;
        this.Epoch = Epoch;
        this.NumberToGauss = NumberToGauss;
    }

    // 游戏参数满足允许后，进行游戏初始化；
    // >> TODO 因为构造方法是私有的，无法被外部使用，所以在调用"Game_generate"类的时候，无法构造"Game_generate"实例，只能通过静态方法来构造实例。
    public static Game_generate game_generate_init(int RangeStart, int RangeEnd, int Epoch) {

        // 判断数字范围是否合法
        int mod = RangeEnd - RangeStart;
        if (RangeStart < 0 || RangeEnd < 0) {
            System.out.println("起始范围必须是非负数！");
            return null;
        }
        if (mod <= 1) {
            System.out.println("非法的数字范围：[" + RangeStart + "," + RangeEnd + "]");
            return null;
        }

        // 返回结果
        System.out.println("猜数字游戏已创建，数字范围为：(" + RangeStart + "," + RangeEnd + ")，共有\"" + Epoch + "\"次机会，输入-1结束游戏！");
        return new Game_generate(RangeStart, RangeEnd, Epoch, Generate_Random(RangeStart, RangeEnd));

    }

    // 生成指定范围内的随机数
    private static int Generate_Random(int RangeStart, int RangeEnd) {

        int mod = RangeEnd - RangeStart;
        int RandomNumber = (int) (Math.random() * 100 + RangeEnd);
        int NumberToGauss = (RandomNumber % mod) + RangeStart;
        if (NumberToGauss == RangeStart) {
            NumberToGauss += 1;
        }
        if (NumberToGauss == RangeEnd) {
            NumberToGauss -= 1;
        }
        return NumberToGauss;
    }

    // 读取私有成员变量的值
    public int Get_RangeStart(){
        return RangeStart;
    }
    public int Get_RangeEnd(){
        return RangeEnd;
    }
    public int Get_Epoch(){
        return Epoch;
    }
    // 取出生成的随机数
    public int Get_NumberToGauss() {
        return NumberToGauss;
    }


}
