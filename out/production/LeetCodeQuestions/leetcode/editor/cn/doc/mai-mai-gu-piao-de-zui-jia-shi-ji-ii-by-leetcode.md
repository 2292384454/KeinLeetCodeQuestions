#### 摘要
 
我们必须确定通过交易能够获得的最大利润（对于交易次数没有限制）。为此，我们需要找出那些共同使得利润最大化的买入及卖出价格。

#### 解决方案

#### 方法一：暴力法

这种情况下，我们只需要计算与所有可能的交易组合相对应的利润，并找出它们中的最大利润。

```java [VTpMRUsC-Java]
class Solution {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }
}
```


**复杂度分析**

* 时间复杂度：*O(n^n)*，调用递归函数 *n^n* 次。

* 空间复杂度：*O(n)*，递归的深度为 *n*。




---
#### 方法二：峰谷法

**算法**

假设给定的数组为：

[7, 1, 5, 3, 6, 4]

如果我们在图表上绘制给定数组中的数字，我们将会得到：

 [Profit Graph](https://pic.leetcode-cn.com/d447f96d20d1cfded20a5d08993b3658ed08e295ecc9aea300ad5e3f4466e0fe-file_1555699515174)


如果我们分析图表，那么我们的兴趣点是连续的峰和谷。

用数学语言描述为：
![TotalProfit=\sum_{i}(height(peak_i)-height(valley_i)) ](./p___Total_Profit=_sum_{i}_height_peak_i_-height_valley_i____.png) 

关键是我们需要考虑到紧跟谷的每一个峰值以最大化利润。如果我们试图跳过其中一个峰值来获取更多利润，那么我们最终将失去其中一笔交易中获得的利润，从而导致总利润的降低。

例如，在上述情况下，如果我们跳过 *peak_i* 和 *valley_j* 试图通过考虑差异较大的点以获取更多的利润，获得的净利润总是会小与包含它们而获得的净利润，因为 *C* 总是小于 *A+B*。


```java [RdFShsdT-Java]
class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
}
```


**复杂度分析**

* 时间复杂度：*O(n)*。遍历一次。

* 空间复杂度：*O(1)*。需要常量的空间。




---
#### 方法三：简单的一次遍历

**算法**

该解决方案遵循 [方法二](#方法二：峰谷法) 的本身使用的逻辑，但有一些轻微的变化。在这种情况下，我们可以简单地继续在斜坡上爬升并持续增加从连续交易中获得的利润，而不是在谷之后寻找每个峰值。最后，我们将有效地使用峰值和谷值，但我们不需要跟踪峰值和谷值对应的成本以及最大利润，但我们可以直接继续增加加数组的连续数字之间的差值，如果第二个数字大于第一个数字，我们获得的总和将是最大利润。这种方法将简化解决方案。
这个例子可以更清楚地展现上述情况：

[1, 7, 2, 3, 6, 7, 6, 7]


与此数组对应的图形是：

 [Profit Graph](https://pic.leetcode-cn.com/6eaf01901108809ca5dfeaef75c9417d6b287c841065525083d1e2aac0ea1de4-file_1555699697692)


从上图中，我们可以观察到 *A+B+C* 的和等于差值 *D* 所对应的连续峰和谷的高度之差。

```java [tAnwmbuj-Java]
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
```


**复杂度分析**

* 时间复杂度：*O(n)*，遍历一次。
* 空间复杂度：*O(1)*，需要常量的空间。