package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            return List.of(List.of(1));
        } else if (numRows == 2) {
            return List.of(List.of(1), List.of(1, 1));
        } else {
            LinkedList<List<Integer>> triangle = new LinkedList<>(List.of(List.of(1), List.of(1, 1)));
            while (triangle.size() < numRows) {
                List<Integer> layerAbove = triangle.getLast();
                List<Integer> layer = new ArrayList<>(layerAbove.size() + 1);
                layer.add(1);
                for (int index = 0; index < layerAbove.size() - 1; index++) {
                    layer.add(layerAbove.get(index) + layerAbove.get(index + 1));
                }
                layer.add(1);
                triangle.add(layer);
            }
            return triangle;
        }
    }
}
