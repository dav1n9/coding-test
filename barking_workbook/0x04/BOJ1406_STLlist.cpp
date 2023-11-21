#include <bits/stdc++.h>
using namespace std;

string str;
int m;
string c;
char w;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> str;
    
    list<char> L;
    list<char>::iterator t = L.end();
    for(auto c : str) {
        L.push_back(c);
    }
    
    cin >> m;

    for(int i = 0; i < m; i++) {
        cin >> c;
        if(c == "L") {
            if(t != L.begin())
                t--;
        } else if(c == "D") {
            if(t != L.end())
                t++;
        } else if(c == "B") {
            if(t != L.begin()) {
                t--;
                t = L.erase(t);
            }
        } else {
            cin >> w;
            L.insert(t, w);
        }
    }

    for(auto a : L) cout << a;
}