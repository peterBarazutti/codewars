package one_kyu.minesweeper.src;

public class TestMain {

    public static void main(String[] args) {
        Minesweeper ms = new Minesweeper();
        String[][] res = ms.processInputMap("0 0\n1 1");
        for (String[] line:res) {
            for (String ch:line){
                System.out.println(ch);
            }
        }
        System.out.println(res[1][1]);
    }

}
