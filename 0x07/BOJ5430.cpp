#include <bits/stdc++.h>
using namespace std;

int T, n;
string p, s;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T;

    while(T--) { 
        deque<int> dq;  
        bool e = false;
        bool reverse = false;
        cin >> p >> n >> s;

        s = s.substr(1, s.length()+1);
        if(n > 0) {
            string num = "";
            for(int i = 0; i < s.length() ; i++) {
                if(s[i] == ',' || s[i] == ']') {
                    dq.push_back(stoi(num)); 
                    num = "";
                } else {
                    num += s[i];
                }
            }
        }

        for(int i = 0; i < p.length(); i++) {
            if (p[i] == 'R') {
                // reverse
                reverse = !reverse;
                
            } else if (p[i] == 'D') {
                // pop_front
                if(!dq.empty()) {
                    if(reverse)
                        dq.pop_back();
                    else
                        dq.pop_front();
                } else {    // error
                    e = true;
                    break;
                }
            }
        }
        // 출력
        if(!e) {
            if(dq.empty()) {
                cout << "[]" << "\n";
            } else {
                cout << "[";
                if(reverse) {
                    while(dq.size() > 1) {
                        cout << dq.back() << ",";
                        dq.pop_back();
                    }
                    cout << dq.front();
                } else {
                    while(dq.size() > 1) {
                        cout << dq.front() << ",";
                        dq.pop_front();
                    }
                    cout << dq.front();
                }
                cout << "]" << "\n";
            }
        } else {
            cout << "error" << "\n";
        }
        
    }
}