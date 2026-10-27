# PagaAi Mobile

Aplicativo Android para o gerenciamento financeiro de uma residência universitária: moradores, mensalidades, pagamentos, pendências e despesas.

## Perfis
- **Administrador**: dashboard, moradores, pagamentos, pendências, despesas e resumo financeiro.
- **Morador**: dashboard pessoal, pagamentos, pendências, histórico e perfil.

## Stack
- Java
- Views em XML + Material Components + View Binding
- MVVM (ViewModel + LiveData) com camadas `ui` / `domain` / `data`
- Navigation Component (Fragments)
- Hilt (injeção de dependência)
- Room (banco local) + SharedPreferences (sessão)
- Retrofit + Gson (API)

## Estrutura
```
app/src/main/java/com/pagaai/app/
├── core/      # DI e utilitários
├── domain/    # modelos, interfaces de repositório e casos de uso
├── data/      # Room, sessão, API, mappers e implementações dos repositórios
└── ui/        # Activities (auth, admin, morador) e telas em Fragments
app/src/main/res/
├── layout/      # activity_*, fragment_*, item_* (listas)
├── navigation/  # grafos de navegação
└── menu/        # barras de navegação inferior
```

Requisitos completos em [`docs/requisitos.md`](docs/requisitos.md).
