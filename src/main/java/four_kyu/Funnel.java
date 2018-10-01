package four_kyu;


import java.util.Arrays;

public class Funnel {


    String[] data;

    String funnelLevelFive;
    String funnelLevelFour;
    String funnelLevelThree;
    String funnelLevelTwo;
    String funnelLevelOne;

    public Funnel() {
        data = new String[15];
        funnelLevelFive = "\\%s %s %s %s %s/\n";
        funnelLevelFour = " \\%s %s %s %s/\n";
        funnelLevelThree = "  \\%s %s %s/\n";
        funnelLevelTwo = "   \\%s %s/\n";
        funnelLevelOne = "    \\%s/\n";
        Arrays.fill(data, " ");
    }


    public void fill(char... args) {
        for (char c : args) {
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals(" ")) {
                    data[i] = String.valueOf(c);
                    break;
                }
            }
        }
    }

    public Character drip() {
        if (data[0].equals(" ")){
            return null;
        } else {
            String droppedElem = data[0];
            evictCell(0);
            return droppedElem.charAt(0);
        }
    }

    private void evictCell(int cellIndex) {
        int leftParent = calcLeftParentIndex(cellIndex);
        int rightParent = leftParent + 1;
        int leftPriority = calcCellPriority(leftParent);
        int rightPriority = calcCellPriority(rightParent);

        if (leftPriority == 0 && rightPriority == 0) {
            data[cellIndex] = " ";
        } else if (leftPriority >= rightPriority) {
            data[cellIndex] = data[leftParent];
            evictCell(leftParent);
        } else if (rightPriority > leftPriority) {
            data[cellIndex] = data[rightParent];
            evictCell(rightParent);
        }
    }

    private int calcCellPriority(int cellIndex) {
        int priorityValue = 0;
        if (data[cellIndex].equals(" ")) {
            return priorityValue;
        } else {
            priorityValue++;
            int leftIndex, rightIndex;
            leftIndex = calcLeftParentIndex(cellIndex);
            rightIndex = leftIndex + 1;
            priorityValue += calcCellPriority(leftIndex) + calcCellPriority(rightIndex);
        }
        return priorityValue;
    }

    private int calcLeftParentIndex(int cellIndex) {
        int level = 1;
        int sum = 1;
        while (cellIndex >= sum) {
            level++;
            sum += level;
        }
        return cellIndex + level;
    }

    @Override
    public String toString() {
        return String.format(funnelLevelFive, Arrays.copyOfRange(data, 10, 15))
                .concat(String.format(funnelLevelFour, Arrays.copyOfRange(data, 6, 10)))
                .concat(String.format(funnelLevelThree, Arrays.copyOfRange(data, 3, 6)))
                .concat(String.format(funnelLevelTwo, Arrays.copyOfRange(data, 1, 3)))
                .concat(String.format(funnelLevelOne, Arrays.copyOfRange(data, 0, 1)));
    }


}
