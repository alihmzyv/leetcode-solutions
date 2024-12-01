package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>(
                Arrays.asList(
                        new NestedIntegerImpl<>( // []
                                new ArrayList<>()
                        ),
                        new NestedIntegerImpl<>( // [[]]
                                new ArrayList<>(
                                        Arrays.asList(
                                                new NestedIntegerImpl<>(new ArrayList<>())
                                        )
                                )
                        ),
                        new NestedIntegerImpl<>(-4), // -4
                        new NestedIntegerImpl<>( // [[[]]]
                                new ArrayList<>(
                                        Arrays.asList(
                                                new NestedIntegerImpl<>(
                                                        new ArrayList<>(
                                                                Arrays.asList(
                                                                        new NestedIntegerImpl<>(new ArrayList<>())
                                                                )
                                                        )
                                                )
                                        )
                                )
                        ),
                        new NestedIntegerImpl<>( // [[], 2, [[]], [[-3], 1], [[],-1]]
                                new ArrayList<>(
                                        Arrays.asList(
                                                new NestedIntegerImpl<>( // []
                                                        new ArrayList<>()
                                                ),
                                                new NestedIntegerImpl<>(2), // 2
                                                new NestedIntegerImpl<>( // [[]]
                                                        new ArrayList<>(
                                                                Arrays.asList(
                                                                        new NestedIntegerImpl<>(new ArrayList<>())
                                                                )
                                                        )
                                                ),
                                                new NestedIntegerImpl<>( // [[-3], 1]
                                                        new ArrayList<>(
                                                                Arrays.asList(
                                                                        new NestedIntegerImpl<>( // [-3]
                                                                                new ArrayList<>(
                                                                                        Arrays.asList(new NestedIntegerImpl<>(-3))
                                                                                )
                                                                        ),
                                                                        new NestedIntegerImpl<>(1) // 1
                                                                )
                                                        )
                                                ),
                                                new NestedIntegerImpl<>( // [[],-1]
                                                        new ArrayList<>(
                                                                Arrays.asList(
                                                                        new NestedIntegerImpl<>( // []
                                                                                new ArrayList<>()
                                                                        ),
                                                                        new NestedIntegerImpl<>(-1) // -1
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );


        NestedIterator nestedIterator = new NestedIterator(list);
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

    public static class NestedIterator implements Iterator<Integer> {
        private List<NestedInteger> nestedList;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            for (int index = 0; index < nestedList.size(); index++) {
                NestedInteger nestedInteger = nestedList.get(index);
                boolean isInteger = nestedInteger.isInteger();
                if (isInteger) {
                    return nestedList.remove(index).getInteger();
                } else if (!isEmpty(nestedInteger)) {
                    Stack<NestedInteger> stack = new Stack<>();
                    for (int i = 0; i < nestedInteger.getList().size(); i++) {
                        while (!nestedInteger.getList().get(0).isInteger()) {
                            stack.push(nestedInteger);
                            nestedInteger = nestedInteger.getList().get(0);
                        }
                        stack.push(nestedInteger);
                        Integer integerRemoved = nestedInteger.getList().remove(0).getInteger();
                        while (!stack.isEmpty()) {
                            NestedInteger next = stack.pop();
                            if (next.getList().isEmpty()) {
                                if (!stack.isEmpty()) {
                                    NestedInteger previous = stack.peek();
                                    previous.getList().remove(0);
                                } else {
                                    nestedList.remove(index);
                                }
                            }
                        }
                        return integerRemoved;
                    }
                }
            }
            throw new RuntimeException();
        }

        @Override
        public boolean hasNext() {
            if (nestedList.isEmpty()) {
                return false;
            } else {
                for (NestedInteger nestedInteger : nestedList) {
                    if (nestedInteger.isInteger()) {
                        return true;
                    } else {
                        boolean isEmpty = nestedList.stream()
                                .allMatch(this::isEmpty);
                        return !isEmpty;
                    }
                }
            }
            return false;
        }

        private boolean isEmpty(NestedInteger nestedInteger) {
            if (!nestedInteger.isInteger()) {
                if (nestedInteger.getList().isEmpty()) {
                    return true;
                } else {
                    return nestedInteger.getList()
                            .stream()
                            .allMatch(this::isEmpty);
                }
            } else {
                return false;
            }
        }
    }

    public static class NestedIntegerImpl<T> implements NestedInteger {
        private T value;

        public NestedIntegerImpl(T value) {
            this.value = value;
        }

        @Override
        public boolean isInteger() {
            return value.getClass().equals(Integer.class);
        }

        @Override
        public Integer getInteger() {
            return (Integer) value;
        }

        @Override
        public List<NestedInteger> getList() {
            return (List<NestedInteger>) value;
        }

        @Override
        public String toString() {
            return "NestedIntegerImpl{" +
                    "value=" + value +
                    '}';
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
