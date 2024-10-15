public class Candy {
    public int minCandies(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int[] candies = new int[n];
        // 每个孩子至少获得一个糖果
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        // 从左到右遍历
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右到左遍历
        for (int i = n - 2; i >= 0; i--) {// n-2是因为数组下标从0开始，所以数组长度为n，而数组下标最大值为n-1
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 计算总的糖果数量
        int totalCandies = 0;
        for (int candy : candies) {//增强for循环用于遍历candies数组
            System.out.println("每个人的糖果数量："+candy);
            totalCandies += candy;// 累加每个孩子的糖果数量
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        Candy candy = new Candy();
        int[] ratings = {1, 0, 1, 2};//输入样例
        System.out.println("最少需要的糖果数量: " + candy.minCandies(ratings));  // 输出结果
    }
}
