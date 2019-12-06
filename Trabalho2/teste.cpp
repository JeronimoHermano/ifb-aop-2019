#include <bits/stdtr1c++.h>

#define ARQ "Dados.dat" /* arquivo com os dados*/
#define OP_INSERIR '1'
#define OP_ALTERAR '2'
#define OP_APAGAR '3'
#define OP_LISTAR '4'
#define OP_PESQUISAR '5'
#define OP_SAIR '0'
#define OP_PESQ_IDADE '1'
#define OP_PESQ_NOME '2'

using namespace std;

vector<string> MainMenu = {
    "1. Inserir registro",
    "2. Alterar registro",
    "3. Apagar registro",
    "4. Listar registros",
    "5. Pesquisar",
    "0. Sair"};

vector<string> PesqMenu = {
    "1. Pesquisar por intervalo de idades",
    "2. Pesquisar por nome"};

FILE *fp; /*variável global pois é útil ao longo do programa*/

struct Pessoa
{
    string nome;
    int idade;
    float salario char status;
}
