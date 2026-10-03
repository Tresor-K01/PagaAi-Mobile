# PagaAi Mobile

Aplicativo Android para o gerenciamento financeiro de uma residência universitária: moradores, mensalidades, pagamentos, pendências e despesas.

## Perfis
- **Administrador**: dashboard, moradores, pagamentos, pendências, despesas e resumo financeiro.
- **Morador**: dashboard pessoal, pagamentos, pendências, histórico e perfil.

## Stack
- Kotlin + Jetpack Compose (Material 3)
- MVVM + Clean Architecture (`ui` / `domain` / `data`)
- Coroutines + Flow
- Hilt (injeção de dependência)
- Room + DataStore (dados locais)
- Retrofit / Ktor (API)

## Estrutura
```
app/src/main/java/com/pagaai/app/
├── core/      # DI, utilitários e design system (tema e componentes)
├── domain/    # modelos, interfaces de repositório e casos de uso
├── data/      # Room, DataStore, API, mappers e implementações dos repositórios
└── ui/        # navegação e telas (auth, admin, morador)
```

Requisitos completos em [`docs/requisitos.md`](docs/requisitos.md).
