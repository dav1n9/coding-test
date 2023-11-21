#include <bits/stdc++.h>
using namespace std;

string a, b;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> a >> b;

    int alp[26] = {};

    for(auto c : a) alp[c - 'a']++;
    for(auto c : b) alp[c - 'a']--;

    int result = 0;
    for(int i = 0; i < 26; i++) {
        if(alp[i] < 0) result -= alp[i];
        else result += alp[i];
    }

    cout << result;
}