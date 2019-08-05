package zhangq.github.spiral;

/**
 * @author zhangqiuyang
 * Created on 2019/8/3.
 */
public class SpiralApplication {
    private static final int ROWS = 9;
    private static final int COLUMN = 3;
    //总计这么多元素
    private static int TOTAL = ROWS * COLUMN;
    private static final String[][] ARRS = new String[ROWS][COLUMN];

    public static void main(String[] args) {

        //初始化
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMN; j++) {
                ARRS[i][j] = String.valueOf(i) + String.valueOf(j);
                print(ARRS[i][j]);
                if (j == COLUMN - 1) {
                    System.out.println("");
                }
            }
        }

        System.out.println("==============螺旋输出后===============");
        //定义x开始指针
        int xBegin = 0;
        //定义x结束指针
        int xEnd = ROWS - 1;
        //定义y开始指针
        int yBegin = 0;
        //定义y结束指针
        int yEnd = COLUMN - 1;


        //指针偏移状态，每次偏移90度，总计偏移4次，所以后面取mod 4
        int state = 1;

        while (TOTAL > 0) {
            switch (state) {
                //固定x轴，正向扫描，从y最小扫描到y最大
                case 1:
                    for (int i = yBegin; i <= yEnd; i++) {
                        print(ARRS[xBegin][i]);
                        TOTAL--;
                    }
                    xBegin++;
                    break;
                //固定y轴，正向扫描，从x最小扫描到x最大
                case 2:
                    for (int i = xBegin; i <= xEnd; i++) {
                        print(ARRS[i][yEnd]);
                        TOTAL--;
                    }
                    yEnd--;
                    break;
                //固定x轴，反向扫描，从y最大扫描到y最小
                case 3:
                    for (int i = yEnd; i >= yBegin; i--) {
                        print(ARRS[xEnd][i]);
                        TOTAL--;
                    }
                    xEnd--;
                    break;
                //固定y轴，反向扫描，从x最大扫描到x最小
                case 0:
                    for (int i = xEnd; i >= xBegin; i--) {
                        print(ARRS[i][yBegin]);
                        TOTAL--;
                    }
                    yBegin++;
                    break;
                default:
                    break;
            }
            System.out.println();
            //取mod改变状态
            state = (state + 1) % 4;
        }
    }

    /**
     * 输出元素
     *
     * @param val
     */
    private static void print(String val) {
        System.out.print(val + "  ");
    }
}
