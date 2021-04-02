public class find_the_town_judge {

    /*
    *
    *       In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

            If the town judge exists, then:

                -The town judge trusts nobody.
                -Everybody (except for the town judge) trusts the town judge.
                -There is exactly one person that satisfies properties 1 and 2.

            You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

            If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
    * */

    /**
     *
     * @param N - the size of people inside the array including the town judge
     * @param trust trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
     * @return index of who is the town judge or -1 when there is no town judge among N
     */

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }

    public static void main(String [] args){

        find_the_town_judge f=new find_the_town_judge();

        int [][]arr={ {1,2},{3,2}};

        System.out.println(f.findJudge(3, arr ));
    }

    /*
    *   Intuition:
Consider trust as a graph, all pairs are directed edge.
The point with in-degree - out-degree = N - 1 become the judge.

Explanation:
Count the degree, and check at the end.

Time Complexity:
Time O(T + N), space O(N)
    *
    * */
}
