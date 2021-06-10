// package junit5.Supermarket;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Nested;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;

// import java.util.List;

// import static org.junit.jupiter.api.Assertions.*;

// @DisplayName("任意の2つの実数の入力で下端点と上端点が決まり、整数閉区間を示すクラス")
// public class SumPriceTest {
//     private SumPrice sumprice;
    
//     /**
//      * 入力される値によって決められる境界は、必ずその入力値を含まれるようになる。
//      * そのため、2つの入力値のうちに大きい値は切り上げて上端点、小さい値は切り下げて下端点とする。
//      */
//     @Nested
//     class 二つの実数の入力値で下端点と上端点を定義される{
//         @ParameterizedTest(name = "{0}{1}と{2}が入力された場合に境界値は各{3}と{4}になる")
//         @CsvSource({
//                 "'二桁の正数である',11.4,32.7,'11','33'",
//                 "'二桁の正数である',32.7,11.4,'11','33'",
//                 "'二桁の負数である',-42.3,-31.6,'-43','-31'",
//                 "'二桁の負数である',-31.6,-42.3,'-43','-31'",
//                 "'二桁の負数と正数である',-17.4,66.3,'-18','67'",
//                 "'二桁の負数である',66.3,-17.4,'-18','67'",
//                 "'二桁の等しい値である',13.5,13.5,'13','14'"
//         })
//         void 入力順番へ関わらずに二つの入力値を二つの整数の下端点と上端点で定義できる(String text, double inputFirst, double inputSecond, String answerFirst, String answerSecond) throws Exception{
//             closedRangeFunction = new ClosedRangeFunction(inputFirst,inputSecond);
//             List<String> answerList = List.of(answerFirst,answerSecond);
//             assertEquals(answerList,closedRangeFunction.getRange());
//         }
//     }
//     @Nested
//     class 定義された下端点と上端点で整数閉区間を文字列で表記できる{
//         @Test
//         @DisplayName("要件に決められた規格\"[下端点,上端点]\"のように文字列を合成できる")
//         void printTest() throws Exception{
//             closedRangeFunction = new ClosedRangeFunction(-999.99,999.99);
//             assertEquals("[-1000,1000]",closedRangeFunction.getString());
//         }
//     }

//     @Nested
//     class 定義された閉区間にある整数かどうか正しく判断できる{
//         @BeforeEach
//         void 前処理(){
//             closedRangeFunction = new ClosedRangeFunction(-10,10);
//         }

//         @Test
//         void 下端点より小さい整数に対してFalseを渡す() throws Exception{
//             assertFalse(closedRangeFunction.isIncluded(-20));
//         }
//         @Test
//         void 下端点と等しい整数に対してTrueを渡す() throws Exception{
//             assertTrue(closedRangeFunction.isIncluded(-10));
//         }
//         @Test
//         void 下端点と上端点の間にある整数に対してTrueを渡す() throws Exception{
//             assertTrue(closedRangeFunction.isIncluded(0));
//         }
//         @Test
//         void 上端点と等しい整数に対してTrueを渡す() throws Exception{
//             assertTrue(closedRangeFunction.isIncluded(10));
//         }
//         @Test
//         void 上端点より大きい整数に対してFalseを渡す() throws Exception{
//             assertFalse(closedRangeFunction.isIncluded(-20));
//         }
//     }

//     @Nested
//     class 説明1{
//         @Test
//         void test() throws Exception{
//             closedRangeFunction = new ClosedRangeFunction(-10,10);
//             ClosedRangeFunction anotherClosedRange = new ClosedRangeFunction(-10,10);
//             assertTrue(closedRangeFunction.isEqual(anotherClosedRange));
//         }
//     }

//     @Nested
//     class 説明2{
//         @ParameterizedTest(name = "{0}{1}{2}{3}説明")
//         @CsvSource({
//                 "'説明',-9,9,True",
//                 "'説明',-9,10,True",
//                 "'説明',-9,11,False",
//                 "'説明',-10,9,True",
//                 "'説明',-10,10,True",
//                 "'説明',-10,11,False",
//                 "'説明',-11,9,False",
//                 "'説明',-11,10,False",
//                 "'説明',-11,11,False"
//         })
//         void test2(String text, double a, double b, boolean c) throws Exception{
//             closedRangeFunction = new ClosedRangeFunction(-10,10);
//             ClosedRangeFunction anotherClosedRange = new ClosedRangeFunction(a,b);
//             assertEquals(c,closedRangeFunction.isInside(anotherClosedRange));
//         }
//     }
// }
