/**
 * 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의 토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각
 *  1 2 1 3 1 4 1 2
 *  [1 2 1 3] [1 4 1 2]
 *   (1,2,3)..(1,2,4)
 *  [1,2,1,3,1] [4,1,2]
 *   즉, 주여진 배열에서 부분집합 2개로 나뉠때 이때 공통된 인자는 제거,그리고 갯수가 같을경우 count
 *
 *   size가 8 일 경우
 *   1,7
 *   2,6
 *   3,5
 *   4,4
 *   5,3
 *   6,2
 *   7,1
 */
class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        var setA = mutableSetOf<Int>()
        var setB = mutableSetOf<Int>()
        for(i in 1..topping.size-1){
            for(k in 0..i-1){
                setA.add(topping[k])
            }
            for(j in i..topping.size-1){
                setB.add(topping[j])
            }
            if(setA.count()==setB.count()) answer++
            setA = mutableSetOf<Int>()
            setB = mutableSetOf<Int>()
        }
        return answer
    }
}

fun main(){
    var a =Solution()
    a.solution(intArrayOf(1,2,1,3,1,4,1,2))
    a.solution(intArrayOf(1,2,3,1,4))
}