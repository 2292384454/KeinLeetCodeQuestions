这道题在leetcode的美国网站上面有1900多个dislike，看来大家对这个题目意见很大，不过就趁这个机会回顾一下计算机是怎样进行加法操作的。

回顾一下我们小学就开始学习的十进制的加法，比如`15+7`，最低位`5+7`得到`12`，对`10`取模得到`2`，进位为`1`，再高位相加`1+0`再加上进位`1`就得到高位结果`2`,组合起来就是`22`。这里面涉及到了两个数字，一个是相加得到的低位，也就是`5+7`得到的结果`2`，第二个是进位`1`。在二进制的计算中就是要通过位操作来得到结果的低位和进位，对于不同的情况，用表格来表示一下，两个数字分别为`a`和`b`

a | b | 低位 | 进位
:-:|:-:|:-:|:-:
0 | 0 | 0 | 0
1 | 0 | 1 | 0
0 | 1 | 1 | 0
1 | 1 | 0 | 1

从上面的表格就可以发现，`低位 = a^b`，`进位 = a & b`。这样的计算可能要持续多次，回想一下在十进制的计算中，如果进位一直大于0，就得往后面进行计算，在这里也是一

样，只要进位不是0，我们就得一直重复计算低位和进位的操作（需要在下一次计算之前要把进位向左移动一位，这样进位才能和更高位进行运算）。这个时候的`a`和`b`就是刚才计算的低位和进位，用简单的加法迭代的代码表示：

```java
public int getSum(int a, int b) {
    if (a==0) return b;
    if (b==0) return a;
    int lower;
    int carrier;
    while (true) {
        lower = a^b;    // 计算低位
        carrier = a&b;  // 计算进位
        if (carrier==0) break;
        a = lower;
        b = carrier<<1;
    }
    return lower;
}
```
**更多内容请看我的**[**个人博客**](http://sunshuyi.vip?hmsr=leetcode&hmpl=bit%2Dmanipulation&hmcu=home&hmkw=home&hmci=none)或者**关注微信公众号**：**佛西先森**
 [wechat.jpg](https://pic.leetcode-cn.com/57553b710defc43220c432d9caba6267fb9613e1537c7a14eeae4c28b90b5c22-wechat.jpg)