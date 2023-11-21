#include <bits/stdc++.h>
using namespace std;

const int MX = 1000005;
char dat[MX];
int pre[MX], nxt[MX];
int unused = 1;
int length = 0;

void insert(int addr, char alp) {
    dat[unused] = alp;
    pre[unused] = addr;
    nxt[unused] = nxt[addr];

    if( nxt[addr] != -1 ) pre[nxt[addr]] = unused;
    nxt[addr] = unused;

    length++;
    unused++;
}

void erase(int addr) {

    nxt[pre[addr]] = nxt[addr];
    if( nxt[addr] != -1 ) pre[nxt[addr]] = pre[addr];

    length--;
}

void traverse() {
    int cur = nxt[0];
    while(cur != -1) {
        cout << dat[cur];
        cur = nxt[cur];
    }
}


string s;
int m;
string c;
char w;

int cursor = 0;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    // 1. 야매(?) 연결리스트로 풀기
    fill(pre, pre+MX, -1);
    fill(nxt, nxt+MX, -1);

    cin >> s;
    for(auto a : s) {
        insert(cursor++, a);
    }

    cin >> m;

    for(int i = 0; i < m; i++) {
        cin >> c;
        if(c == "L") {
            if(pre[cursor] != -1)
                cursor = pre[cursor];
        } else if(c == "D") {
            if(nxt[cursor] != -1)
                cursor = nxt[cursor];
        } else if(c == "B") { 
            if(pre[cursor] != -1) {
                erase(cursor);
                cursor = pre[cursor];
            }
        } else {
            cin >> w;
            insert(cursor, w);
            cursor = nxt[cursor];
        }
    }

    traverse();
}