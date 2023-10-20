#include <bits/stdc++.h>
using namespace std;

int K;
stack<int> S;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> K;

    int max = 1;
    string result = "";

    while(K-- > 0) {
        int a;
        cin >> a;

        while (max <= a) {
            S.push(max);
            result += "+\n";
            max++;
        }

        
        if (S.top() == a) {    
            S.pop();
            result += "-\n";
        } else {
            cout << "NO";
            return 0;
        }
    }

    cout << result;
}