#include <bits/stdc++.h>
using namespace std;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

int n, m;

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;
    int board[n][m];
    bool vis[n][m];
    for(int i = 0; i < n; n++) {
        for(int j = 0; j < m; j++) {
            int num;
            cin >> num;
            board[i][j] = num;
        }
    }

    queue<pair<int, int>> Q;
    vis[0][0] = 1;  // 시작점 (0, 0)을 방문했다고 명시
    Q.push({0,0});

    while(!Q.empty()) {
        pair<int, int> cur = Q.front();
        Q.pop();
        cout << '(' << cur.first << ", " << cur.second << ") -> ";

        for(int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(vis[nx][ny] || board[nx][ny] != 1) continue;
            vis[nx][ny] = 1;
            Q.push({nx, ny});
        }
    }
}