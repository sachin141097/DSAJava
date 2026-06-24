package StackQueue;

public class TrappingRainWater {
    private static int trappedWater(int[] height) {
        int[] leftMaximum = new int[height.length];
        int[] rightMaximum = new int[height.length];
        leftMaximum[0] = height[0];
        rightMaximum[rightMaximum.length - 1] = height[height.length - 1];
        for (int i = 1; i < leftMaximum.length; i++) {
            leftMaximum[i] = Math.max(leftMaximum[i - 1], height[i]);
        }
        for (int i = rightMaximum.length - 2; i >= 0; i--) {
            rightMaximum[i] = Math.max(rightMaximum[i + 1], height[i]);
        }
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            trappedWater += Math.min(leftMaximum[i], rightMaximum[i]) - height[i];
        }
        return trappedWater;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trappedWater(height));
    }
}
