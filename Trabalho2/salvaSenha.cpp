#include <bits/stdc++.h>

using namespace std;

typedef struct
{
    char user[30];
    char password[20];
} TipoSystem;

void writeSistema(TipoSystem *sistema)
{
    remove("start.bin");
    FILE *arq = fopen("start.bin", "wb");
    if (!arq)
    {
        puts("Erro na escrita de start.bin");
        exit(0);
    }

    fwrite(sistema, sizeof(TipoSystem), 1, arq);
    fclose(arq);
}

int main()
{
    // string user = "user";
    // string password = "pass123";
    // cin >> user;
    // cin >> password;
    TipoSystem s;

    // char usuario[30];
    // char senha[20];

    //bom lkkk
    char user[30] = {'u', 's', 'e', 'r', '\0'};
    char senha[20] = {'p', 'a', 's', 's', '1', '2', '3', '\0'};

    strcpy(s.user, user);
    strcpy(s.password, senha);

    writeSistema(&s);
}
