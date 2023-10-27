#include <iostream>
#include<utility>
#include <string>
#include <map>

using namespace std;

// 파라미터로 주어지는 문자열은 const로 주어집니다. 변경하려면 문자열을 복사해서 사용하세요.
int solution(string dirs) {
    int answer = 0;
    map<pair<pair<int, int>, pair<int, int>>, bool> routes = {};

    int nextX = 0;
    int nextY = 0;
    for (int i = 0; i < dirs.length(); i++) {
        int currentX = nextX;
        int currentY = nextY;

        if (dirs[i] == 'U' && -5 <= nextX - 1) {
            if (nextX - 1 < -5) continue;
            nextX--;
        }
        if (dirs[i] == 'D') {
            if (5 < nextX + 1) continue;
            nextX++;
        }
        if (dirs[i] == 'R') {
            if (5 < nextY + 1) continue;
            nextY++;
        }
        if (dirs[i] == 'L') {
            if (nextY - 1 < -5) continue;
            nextY--;
        }

        if (routes[make_pair(make_pair(currentX, currentY), make_pair(nextX, nextY))]) continue;

        routes[make_pair(make_pair(currentX, currentY), make_pair(nextX, nextY))] = true;
        routes[make_pair(make_pair(nextX, nextY), make_pair(currentX, currentY))] = true;
        answer++;
    }

    return answer;
}
