#include <bits/stdc++.h>

using namespace std;
#define N 10
#define WHITE 1
#define GREY 2
#define BLACK 3
#define NIL -1
#define INF 1e9
int prevv[N + 1];
int color[N + 1];
int node = N;
bool flag = false;

int p;

void DFS_Visit(int graph[][N], int u)
{
    color[u] = GREY;

    for (int v = 0; v < node; v++)
    {

        if (graph[u][v] == 1 && color[v] == GREY)
        {
            flag = true;
        }

        else if (graph[u][v] == 1 && color[v] == BLACK)
        {
            flag=false;
        }

        else if (graph[u][v] == 1 && color[v] == WHITE)
        {
            prevv[v] = u;
            DFS_Visit(graph, v);
        }
    }

    color[u] = BLACK;
}
void DFS(int graph[][N])
{

    for (int u = 0; u < node; u++)
    {
        color[u] = WHITE;
        prevv[u] = -1;
    }
    for (int u = 0; u < node; u++)
    {

        if (color[u] == WHITE)
        {
            DFS_Visit(graph, u);
        }
    }
}

vector<string> split(string str, char del){
    // declaring temp string to store the curr "word" upto del
      string temp = "";
      vector<string> a;
   
      for(int i=0; i<(int)str.size(); i++){
        // If cur char is not del, then append it to the cur "word", otherwise
          // you have completed the word, print it, and start a new word.
         if(str[i] != del){
            temp += str[i];
        }
          else{
            a.push_back(temp);
            temp = "";
        }
    }
       
      
       a.push_back(temp);

       //cout<<a<<endl;

       return a;
}

int main()
{
    vector<string> x;

    string myText;

// Read from the text file
ifstream MyReadFile("ConfSerInput.txt");

// Use a while loop together with the getline() function to read the file line by line
//vector<string> a;
while (getline (MyReadFile, myText)) {
    x=split(myText,',');
}


// Close the file
MyReadFile.close();


//cout<<x[3];

cout<<endl;

    // string in;
    // while (cin >> in)
    // {
    //     x.push_back(in);
    //     if(in=="end")
    //     break;
    // }
 set<char>st;

    for (auto i : x)
{
  
   st.insert(i[1]);
   //p=st.size();

   //cout<<p<<"bbbbbbbbbbbbbbbbbbbbbbbb";
}
    p=st.size();
 //cout<<st.size()<<"bbbbbbbbbbbbbbbbbbbbbbbb";

    int adj_matrix[N][N] = {0};
    //adj_matrix[0][2] = 0;
    for (int i = 0; i < x.size(); i++)
    {
        for (int j = i + 1; j < x.size(); j++)
        {
            if (x[i][3] == x[j][3])
            {
                if ((x[i][0] == 'R' && x[j][0] == 'W') || (x[i][0] == 'W' && (x[j][0] == 'R' || x[j][0] == 'W')))
                {
                    cout << x[i][0] << x[j][0];
                    int a = (int)x[i][1] - 48;

        
                    int b = (int)x[j][1] - 48;

                    cout<<x[i][1]<<" "<<x[j][1]<<endl;
                    cout<<a<<" "<<b<<"  "<<endl;
                    if (a != b){
                        adj_matrix[a][b] = 1;
                    }
                }
            }
        }
    }



    DFS(adj_matrix);
    if (flag == true)
    {
        cout << "Conflict serialization  not possible";
    }
    else
    {
        cout << "Conflict serialization   possible";
    }
  cout<<endl;

    for(int t=0;t<p+1;t++)
    {
        for(int k=0;k<p+1;k++)
         cout<<adj_matrix[t][k]<<" ";

         cout<<endl;
    }
}