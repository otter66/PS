#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = -1;
    int maxCalcCount = queue1.size() * 4;
    queue<int> q1, q2;
    long long q1Sum = 0, q2Sum = 0;
    for (int i = 0; i < queue1.size(); i++) {
        q1.push(queue1[i]);
        q1Sum += queue1[i];
        q2.push(queue2[i]);
        q2Sum += queue2[i];
    }

    for (int i = 0; i < maxCalcCount; i++) {
        if (q1Sum == q2Sum) return i;

        if (q2Sum < q1Sum && 0 < q1.size()) {
            q2Sum += q1.front();
            q1Sum -= q1.front();
            q2.push(q1.front());
            q1.pop();
        } else if (q1Sum < q2Sum && 0 < q2.size()) {
            q1Sum += q2.front();
            q2Sum -= q2.front();
            q1.push(q2.front());
            q2.pop();
        }
    }

    return answer;
}