#include <bits/stdc++.h>

using namespace std;
#define N 10
#define WHITE 1
#define GREY 2
#define BLACK 3
#define NIL -1
#define INF 1e9
int previous[N + 1];
int color[N + 1];
int node = N;
bool flag = false;

int numOfTransactions;

void DFS_Visit(int graph[][N], int u){
    color[u] = GREY;

    for (int v = 0; v < node; v++){

        if (graph[u][v] == 1 && color[v] == GREY){
            flag = true;
        }

        else if (graph[u][v] == 1 && color[v] == BLACK){
            flag=false;
        }

        else if (graph[u][v] == 1 && color[v] == WHITE){
            previous[v] = u;
            DFS_Visit(graph, v);
        }
    }

    color[u] = BLACK;
}
void DFS(int graph[][N]){

    for (int u = 0; u < node; u++){
        color[u] = WHITE;
        previous[u] = -1;
    }
    for (int u = 0; u < node; u++){

        if (color[u] == WHITE){
            DFS_Visit(graph, u);
        }
    }
}

vector<string> split(string str, char del){
      string temp = "";
      vector<string> firstTransaction;
   
      for(int i=0; i<(int)str.size(); i++){
         if(str[i] != del){
            temp += str[i];
        }
          else{
            firstTransaction.push_back(temp);
            temp = "";
        }
    }
       
      
    firstTransaction.push_back(temp);

    //cout << firstTransaction<<endl;

    return firstTransaction;
}

int main(){

    vector<string> input;

    string myText;

    ifstream MyReadFile("ConfSerInput.txt");

    while (getline (MyReadFile, myText)) {
        input=split(myText,',');
    }

    MyReadFile.close();

    // cout<<input[3];

    cout<<endl;

    set<char>Transactions;

    for (auto i : input){
        
        Transactions.insert(i[1]);
        //numOfTransactions = Transactions.size();

    }
    // for (auto it = Transactions.begin(); it !=Transactions.end(); ++it)
    //         cout << ' ' << *it;
    // cout << endl;

    numOfTransactions = Transactions.size();

    int adj_matrix[N][N] = {0};
    //adj_matrix[0][2] = 0;

    for (int i = 0; i < input.size(); i++){

        for (int j = i + 1; j < input.size(); j++){

            if (input[i][3] == input[j][3]){

                if(input[i][0] == 'R' && input[j][0] == 'R'){
                    continue;
                }
                else{
                    cout << input[i][0] << input[j][0];

                    int firstTransaction = (int)input[i][1] - 48;
                    int secondTransaction = (int)input[j][1] - 48;

                    cout << input[i][1] << " " << input[j][1] << endl;
                    cout << firstTransaction << " " << secondTransaction << "  " << endl;

                    if (firstTransaction != secondTransaction){
                        adj_matrix[firstTransaction][secondTransaction] = 1;
                    }
                }
            }
        }
    }


    DFS(adj_matrix);

    if (flag == true){
        cout << "Cycle detected! Conflict serialization is NOT possible";
    }
    else{
        cout << "No cycle found. Conflict serialization is possible";
    }
    
    cout<<endl;

    for(int t=0; t<numOfTransactions+1; t++){
        for(int k=0; k<numOfTransactions+1; k++)
            cout << adj_matrix[t][k] << " ";

        cout << endl;
    }
}