package co.cubestudio.arrays.fibonacci2048;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class FibonacciSeriesLookUpTable {
    private static final int LIMIT = 1 << 16;
    private static final int[] fibs;
    private static final Map<Integer, Integer> index;

    static {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1); tmp.add(1);
        while (true) {
            int next = tmp.get(tmp.size()-1) + tmp.get(tmp.size()-2);
            if (next > LIMIT) break;
            tmp.add(next);
        }
        fibs = tmp.stream().mapToInt(i->i).toArray();
        index = new HashMap<>();
        for (int i=0;i<fibs.length;i++) index.put(fibs[i], i);
    }

    boolean areInSequence(int a, int b) {
        Integer ia = index.get(a);
        Integer ib = index.get(b);
        return ia != null && ib != null && Math.abs(ia - ib) == 1;
    }
}
