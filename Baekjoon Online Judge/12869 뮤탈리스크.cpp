#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;

int n = 0;
int hp[3]{};
bool visited[61][61][61]{};

int da[6] = {9, 3, 1, 9, 3, 1};
int db[6] = {3, 1, 9, 1, 9, 3};
int dc[6] = {1, 9, 3, 3, 1, 9};

int main() {
    int best = 0;

    cin >> n;
    for (int i = 0; i < n; i++) cin >> hp[i];

    queue<tuple<int, int, int, int>> q; // depth, a, b, c
    q.push(make_tuple(0, hp[0], hp[1], hp[2]));
    visited[hp[0]][hp[1]][hp[2]] = true;

    while (0 < q.size()) {
        tuple<int, int, int, int> current = q.front();
        q.pop();

        int depth = get<0>(current);
        int a = get<1>(current);
        int b = get<2>(current);
        int c = get<3>(current);

        if (a <= 0 && b <= 0 && c <= 0) {
            best = depth;
            break;
        }

        for (int i = 0; i < 6; i++) {
            int nextA = a - da[i]; if (nextA < 0) nextA = 0;
            int nextB = b - db[i]; if (nextB < 0) nextB = 0;
            int nextC = c - dc[i]; if (nextC < 0) nextC = 0;
            if (visited[nextA][nextB][nextC]) continue;
            visited[nextA][nextB][nextC] = true;
            q.push(make_tuple(depth + 1, nextA, nextB, nextC));
        }
    }

    cout << best;
}

