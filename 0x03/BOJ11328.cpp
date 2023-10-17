#include <bits/stdc++.h>
using namespace std;

int n;
string a, b;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    int alp[27] = {};

    for(int i = 0; i < n; i++) {
        int result = 0;
        cin >> a >> b;

        for(auto c : a) {
            alp[c-'a']++;
        }

        for(auto c : b) {
            alp[c-'a']--;
        }

        for(int i = 0; i < 27; i++) {
            if( alp[i] != 0) {
                result++;
            }
            alp[i] = 0;
        }

        if(result > 0) {
            cout << "Impossible" << '\n';
        } else {
            cout << "Possible" << '\n'; 
        }
    }
}