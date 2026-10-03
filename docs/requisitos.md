### PagaAi Mobile

O **PagaAi** será um aplicativo mobile desenvolvido para facilitar o gerenciamento financeiro de uma residência universitária. O aplicativo permitirá centralizar o controle de moradores, mensalidades, pagamentos, pendências e despesas, substituindo processos manuais realizados por meio de planilhas e mensagens.

O sistema terá dois tipos principais de usuários: **Administrador** e **Usuário comum (morador)**. Cada perfil terá permissões e funcionalidades diferentes de acordo com sua função no sistema.

### 1. Acesso ao aplicativo

Ao abrir o aplicativo, o usuário será direcionado para a tela de **login**, onde deverá informar suas credenciais de acesso, como e-mail/telefone e senha.

Após a autenticação, o sistema identificará o tipo de usuário e direcionará para a interface correspondente.

* **Administrador:** terá acesso às funções de gerenciamento da residência.
* **Usuário comum:** terá acesso apenas às suas próprias informações financeiras e dados disponibilizados pelo sistema.

Caso o usuário informe credenciais inválidas, o aplicativo deverá apresentar uma mensagem informando que os dados estão incorretos. O sistema também poderá disponibilizar funcionalidades de recuperação de senha.

### 2. Área do Administrador

Após realizar o login, o administrador terá acesso ao **Dashboard**, que funcionará como a tela principal de gerenciamento da residência.

No Dashboard serão apresentados indicadores como:

* saldo atual da residência;
* total recebido no período;
* total de despesas;
* quantidade de moradores;
* quantidade de moradores com pendências;
* valor total das pendências;
* movimentações financeiras recentes.

A partir dessa tela, o administrador poderá acessar as principais funcionalidades do sistema.

### 3. Gerenciamento de moradores

O administrador poderá cadastrar novos moradores informando dados como:

* nome;
* telefone;
* quarto;
* valor da mensalidade;
* informações necessárias para identificação no sistema.

Também poderá visualizar a lista de moradores cadastrados, pesquisar um morador e acessar seus detalhes.

Na página de cada morador, o administrador poderá visualizar informações cadastrais, pagamentos realizados, meses pendentes e histórico financeiro.

Caso um morador deixe a residência, o administrador poderá **inativar seu cadastro**, preservando seu histórico de pagamentos e movimentações.

### 4. Gerenciamento de pagamentos

O administrador poderá registrar os pagamentos realizados pelos moradores.

Para registrar um pagamento, deverá informar, por exemplo:

* morador;
* valor;
* data do pagamento;
* mês de referência.

Após o registro, o sistema atualizará automaticamente a situação financeira daquele morador.

O administrador também poderá consultar o histórico de pagamentos, pesquisar movimentações e corrigir informações cadastradas quando necessário.

### 5. Controle de pendências

O PagaAi deverá calcular automaticamente as pendências dos moradores com base nos pagamentos registrados.

O administrador poderá acessar uma tela específica de **Pendências**, contendo informações como:

* nome do morador;
* meses pendentes;
* quantidade de meses em atraso;
* valor total pendente.

Ao selecionar um morador, será possível visualizar detalhadamente quais mensalidades ainda não foram pagas.

A partir dessas informações, o administrador poderá acompanhar a situação financeira dos moradores e, futuramente, enviar lembretes de pagamento.

### 6. Gerenciamento de despesas

O administrador também poderá registrar as despesas da residência.

Cada despesa poderá conter informações como:

* descrição;
* valor;
* data;
* categoria;
* observação.

Por exemplo:

> Compra de gás — R$ 120,00 — 10/09/2026.

O administrador poderá consultar o histórico, editar informações e, de acordo com suas permissões, cancelar registros lançados incorretamente.

### 7. Controle financeiro

Com base nos pagamentos e despesas registrados, o sistema apresentará um resumo financeiro da residência.

O administrador poderá visualizar:

* total de receitas;
* total de despesas;
* saldo;
* valores pendentes;
* movimentações do mês;
* histórico financeiro.

Também será possível selecionar um período específico para consultar a movimentação financeira.

### 8. Área do usuário comum

O usuário comum terá uma interface mais simples e voltada principalmente para o acompanhamento da sua própria situação.

Após o login, ele será direcionado para seu **Dashboard pessoal**, onde poderá visualizar:

* situação da mensalidade;
* valor devido;
* meses pagos;
* meses pendentes;
* histórico de pagamentos;
* informações básicas do seu cadastro.

O usuário comum **não terá acesso aos dados financeiros dos outros moradores**, nem poderá alterar informações administrativas da residência.

### 9. Consulta de pagamentos pelo morador

O usuário poderá acessar seu histórico de pagamentos e visualizar informações como:

* data do pagamento;
* valor;
* mês de referência;
* situação do pagamento.

Dessa forma, o próprio morador poderá acompanhar seus pagamentos sem precisar solicitar essas informações ao administrador.

### 10. Consulta de pendências pelo morador

Caso existam mensalidades pendentes, o aplicativo apresentará essa informação de maneira clara.

Por exemplo:

> **Pendências:**
> Agosto — R$ 20,00
> Setembro — R$ 20,00
> **Total: R$ 40,00**

O usuário poderá acompanhar quais meses ainda estão pendentes e o valor correspondente.

### 11. Notificações

Em versões futuras, o PagaAi poderá utilizar notificações para informar os usuários sobre acontecimentos importantes.

Para o morador:

* lembrete de mensalidade;
* confirmação de pagamento;
* aviso de pendência.

Para o administrador:

* novos pagamentos;
* pendências;
* movimentações relevantes.

### 12. Permissões

O sistema deverá controlar o acesso de acordo com o perfil do usuário.

**Administrador:**

* gerenciar moradores;
* registrar pagamentos;
* consultar pagamentos;
* controlar pendências;
* registrar despesas;
* consultar receitas e despesas;
* visualizar o saldo;
* acessar relatórios;
* gerenciar informações da residência.

**Usuário comum:**

* visualizar seu próprio perfil;
* consultar seus pagamentos;
* consultar suas pendências;
* visualizar seu histórico financeiro;
* receber notificações relacionadas à sua situação.

O usuário comum não poderá visualizar informações financeiras de outros moradores nem realizar operações administrativas.

### 13. Fluxo geral do aplicativo

O funcionamento geral poderá ser representado da seguinte maneira:

**Login → Identificação do perfil → Dashboard → Funcionalidades específicas do usuário**

Para o administrador:

**Login → Dashboard → Moradores / Pagamentos / Pendências / Despesas / Relatórios**

Para o usuário comum:

**Login → Dashboard pessoal → Pagamentos / Pendências / Histórico / Perfil**

Dessa forma, o PagaAi Mobile funcionará como uma plataforma centralizada de gerenciamento financeiro da residência, permitindo que o administrador tenha controle das operações financeiras e que cada morador acompanhe sua própria situação de forma simples e transparente.
