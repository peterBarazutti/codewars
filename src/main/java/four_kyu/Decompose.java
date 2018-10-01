package four_kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Decompose {

    public String decompose(long n) {
        List<Long> resultList = null;
        boolean solutionExists = false;
        Long firstElem = n - 1;
        while (!solutionExists && firstElem > n/2) {
            Long firstLeftover = n * n - firstElem * firstElem;
            resultList = new ArrayList<>(Arrays.asList(firstElem));
            solutionExists = findFragment(firstElem, firstLeftover, resultList);
            firstElem--;
        }
        Collections.sort(resultList);
        if (solutionExists) {
            return resultList.stream().map(Object::toString).collect(Collectors.joining(" "));
        }
        else return null;
    }

    /*private Integer findFragment(int n, List<Integer> decompList) {
        Integer leftover = n * n - decompList
                .stream()
                .map(x -> x * x)
                .reduce(0, (x, y) -> x + y);
        for (int i = decompList.size() == 0
                ? n - 1 : decompList.get(decompList.size() - 1);
             i > 0; i--)
        {
            if (i == 1 && leftover - i != 0) {
                return null;
            } else if (leftover - i * i == 0) {
                decompList.add(i);
                return i;
            }
            else if (leftover - i * i > 0) {
                Integer temp = findFragment(n, decompList);
                if (temp != null) {

                }
            }
        }
        return null;
    }*/

    /*private Integer findFragment(int n, int squareOfLeftover, List<Integer> decompList) {
        for (int i = n * n == squareOfLeftover
                ? n - 1 : (int) Math.sqrt(squareOfLeftover); i > 0; i--) {
            if (squareOfLeftover - i * i == 0) {
                decompList.add(i);
                return i;
            } else if (i == 1) {
                return null;
            } else if (squareOfLeftover - i * i > 0) {
                Integer temp = findFragment(n, squareOfLeftover - i * i, decompList);
                if (temp == null) {
                    return null;
                } else {
                    decompList.add(i);
                    return i;
                }
            }
        }
        return null;
    }*/

    /*private Integer findFragment(int n, int squareOfLeftover, List<Integer> decompList) {
        for (int i = n * n == squareOfLeftover
                ? n - 1 : (int) Math.sqrt(squareOfLeftover); i > 0; i--) {
            Integer temp = squareOfLeftover - i * i;
            if (temp == 0 && !decompList.contains(i)) {
                decompList.add(i);
                return i * i;
            } else if (temp > 0 && !decompList.contains(i)) {
                Integer sum = findFragment(n, squareOfLeftover - i * i, decompList);
                if (sum != null) {
                    sum += i * i;
                }
                if (sum != null && squareOfLeftover == sum) {
                    decompList.add(i);
                    return sum;
                }
            } else if (temp > 0 && i == 1) {
                return null;
            }
        }
        return null;
    }*/

    /*private Integer findFragment(int n, int squareOfLeftover, List<Integer> decompList) {
        for (int i = n * n == squareOfLeftover
                ? n - 1 : (int) Math.sqrt(squareOfLeftover); i > 0; i--) {
            Integer sum = 0;
            Integer temp = squareOfLeftover - i * i;
            if (temp == 0) {
                decompList.add(i);
                return i * i;
            } else if (temp > 0 && i != n) {
                sum = findFragment(i, temp, decompList);
                if (sum != 0) {
                    sum += i * i;
                    if (sum == squareOfLeftover) {
                        decompList.add(i);
                        return sum;
                    }
                }
            }
        }
        return 0;
    }*/

    private boolean findFragment(long n, Long squareOfLeftover, List<Long> decompList) {
        for (long i = (int) Math.sqrt(squareOfLeftover); i > 0; i--) {
            Long temp = squareOfLeftover - i * i;
            if (temp == 0 && n > i) {
                decompList.add(i);
                return true;
            } else if (temp > 0 && i < n && findFragment(i, temp, decompList)) {
                decompList.add(i);
                return true;
            }

        }
        return false;
    }

}
