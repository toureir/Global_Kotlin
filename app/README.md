# EcoDicas - Aplicativo de Dicas Sustentáveis

## Descrição
EcoDicas é um aplicativo Android desenvolvido em Kotlin que permite aos usuários gerenciar e compartilhar dicas sobre práticas sustentáveis e economia de energia. O aplicativo foi projetado com uma interface intuitiva e amigável, utilizando uma temática verde para reforçar seu propósito ambiental.

## Funcionalidades Principais

### 1. Adição de Dicas
- Campo para título da dica
- Campo para descrição detalhada
- Botão "ADICIONAR DICA" para salvar as informações
  ![Tela de Adição](![WhatsApp Image 2024-11-14 at 21 04 56](https://github.com/user-attachments/assets/2f9a8a1e-5121-4e76-a5b1-7d6ba241fb42)
)
).


### 2. Pesquisa de Dicas
- Barra de pesquisa no topo do aplicativo
- Filtragem em tempo real das dicas
- Ícone de limpeza (X) para resetar a pesquisa
  ![Pesquisa em Ação](![WhatsApp Image 2024-11-14 at 21 03 41](https://github.com/user-attachments/assets/137e57b5-15c5-4008-b1e5-19aa0af20b52)
)

### 3. Visualização de Dicas
- Lista de dicas em formato de cards
- Exibição clara do título e descrição
- Design limpo e organizado
  ![Lista de Dicas](![WhatsApp Image 2024-11-14 at 21 03 23](https://github.com/user-attachments/assets/8facb913-3d94-4986-8158-68e4e58ef65d)
)

### 4. Persistência de Dados
- Armazenamento local usando Room Database
- Manutenção das dicas mesmo após fechar o aplicativo
  ![Dicas Salvas](![WhatsApp Image 2024-11-14 at 21 05 16](https://github.com/user-attachments/assets/1a092cb9-52a4-4b1f-be35-b5cf3b3884ff)
)

## Tecnologias Utilizadas
- Kotlin
- Android SDK
- Room Database
- MVVM Architecture
- Material Design Components
- LiveData e ViewModel
- RecyclerView
- Coroutines

## Arquitetura
O projeto segue a arquitetura MVVM (Model-View-ViewModel) e está organizado nas seguintes camadas:
- **Data**: Entidades e DAOs para o Room Database
- **Repository**: Camada de abstração para acesso aos dados
- **ViewModel**: Gerenciamento de estado e lógica de negócios
- **UI**: Activities e Adapters para a interface do usuário

## Identidade Visual
- Tema verde para reforçar a consciência ambiental
- Fundo suave em verde claro para melhor legibilidade
- Elementos de interface consistentes com o Material Design

## Equipe de Desenvolvimento
- Guilherme Loureiro 98722
- Tiago Gomes 95849

## Como Usar
1. Digite o título da dica sustentável
2. Adicione uma descrição detalhada
3. Clique em "ADICIONAR DICA"
4. Use a barra de pesquisa para encontrar dicas específicas
5. Visualize todas as dicas na lista principal

## Requisitos do Sistema
- Android 7.0 (API 24) ou superior
- Aproximadamente 10MB de espaço em disco

## Licença
Este projeto é parte de uma avaliação acadêmica para a FIAP.
