#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <iterator>

using namespace std;

string upper(string str) {
    string s = "";

    for (int i = 0; i < str.length(); i++) {
        s += toupper(str[i]);
    }

    return s;
}

int findIndex(vector<string> arr, string str) {
    int answer = -1;

    for (int i = 0; i < arr.size(); i++) {
        if (arr[i] == str) answer = i;
    }

    return answer;
}

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    vector<string> cache;

    for (int i = 0; i < cities.size(); i++) {
        string str = upper(cities[i]);
        int index = findIndex(cache, str);

        if (index != -1) {
            answer ++;
            cache.erase(remove(cache.begin(), cache.end(), str));
            cache.push_back(str);
            continue;
        }

        answer += 5;
        if (cacheSize == 0) continue;
        if (cacheSize <= cache.size()) cache.erase(remove(cache.begin(), cache.end(), cache[0]));
        cache.push_back(str);
    }

    return answer;
}