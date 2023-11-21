#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int arr[26] = {};
    int index = 0;

    string s;
    cin >> s;

    for(char a = 'a'; a <= 'z'; a++) {
        for(int i = 0; i < s.length(); i++) {
            if(s[i] == a) {
                arr[index]++;
            }
        }
        index++;
    }

    // 정답 풀이 : 
    // for(auto c : s) {
    //    arr[c-'a']++;
    // }
    // c-'a'를 해줌으로서 c가 'a'였다면 0, 'b'였다면 1, ···,  'z'였다면 25...

    for(int i = 0; i < 26; i++) {
        cout << arr[i] << ' ';
    }
}

