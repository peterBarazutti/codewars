package one_kyu.minesweeper.src;

import one_kyu.minesweeper.src.model.Coordinate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Minesweeper {

    private Map<Coordinate, Integer>  cells = new HashMap<>();
    String[][] board;

    public void initProcess(String mapString){
        board = processInputMap(mapString);
    }

    public String[][] processInputMap(String mapString) {
        return Arrays.stream(
                mapString.split("\\n"))
                .map(x -> x.split(" "))
                .toArray(String[][]::new);
    }


}
