#include <bits/stdc++.h>
using namespace std;

int n;
string s;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // STLlist 이용해서 풀기
    cin >> n;
    
    while (n-- > 0) {
        list<char> L;
        auto cursor = L.begin();
    
        cin >> s;
        for(auto a : s) {
            if (a == '<') {
                if(cursor != L.begin())
                    cursor--;
            } else if (a == '>') {
                if(cursor != L.end())
                    cursor++;
            } else if (a == '-') {
                if(cursor != L.begin()) {
                    cursor--;
                    cursor = L.erase(cursor);
                }
            } else {
                L.insert(cursor, a);
            }
        }

        for(auto c : L) cout << c;
        cout << '\n';
    }

}