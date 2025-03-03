# ROMBA EM JAVA GUI

Este foi um projeto realizado durante as aulas de Programação I (Matriz 2019 de Sistemas de Informação da UEG CCET). O objetivo desta atividade foi criar um script em Java, utilizando Java Swing, para criar uma sala com sujeira esparramada aleatoriamente. Havia um robô, chamado Romba, que se movia pela sala virtual e limpava a sujeira. Quando o robô percorresse todos os blocos da sala, a execução terminaria.

## Por que foi atualizado depois de 3 anos?

Em 2021, quando fiz este projeto, não tinha muito entendimento sobre GIT e versionamento. Como fazia muitas alterações no código tentando fazê-lo funcionar, acabei realizando o versionamento manualmente, criando branches separadas para cada mudança.

Após concluir a atividade, subi o projeto para o GITHUB, mas acabei enviando uma versão com alguns bugs que impediam o código de funcionar corretamente.

Após 4 anos, identifiquei o problema. Como havia perdido a solução original, decidi corrigir os bugs que estavam atrapalhando a execução.

## Isto é uma IA de Busca?

Infelizmente, não. Este sistema não segue uma lógica de busca para seguir o caminho mais curto até a sujeira. Além disso, ele precisa percorrer toda a sala, e a decisão de caminho é feita aleatoriamente.

## Instruções de uso

Esta branch não utiliza nenhuma framework para facilitar a criação do código e a sua utilização. Algumas coisas precisam ser feitas manualmente.

A compilação é feita pelo comando `javac` com o seguinte comando:

``javac src/ROOMBA_GUI/AspiradorLogica.java``

Este comando gerará vários arquivos `.class` dentro do código. Existem formas de evitar que esses arquivos sejam gerados na pasta.

Para executar o código, use:

``java src.ROOMBA_GUI.AspiradorLogica``

---

## English Translation

This was a project done during the Programming I classes (2019 Matrix of Information Systems at UEG CCET). The goal of this activity was to create a Java script using Java Swing to create a room with dirt scattered randomly. There was a robot, named Romba, that would move around the virtual room and clean the dirt. When the robot had covered all the blocks of the room, the execution would finish.

## Why was it updated after 3 years?

In 2021, when I did this project, I didn't understand much about GIT and version control. Since I made a lot of changes to the code trying to get it to work, I ended up doing manual version control by creating separate branches for each modification.

After completing the activity, I uploaded the project to GITHUB but ended up uploading a version with some bugs that prevented the code from working properly.

After 4 years, I identified the problem. Since I had lost the original solution, I decided to fix the bugs that were hindering the execution.

## Is this a Search AI?

Unfortunately, no. This system does not follow a search algorithm to take the shortest path to the dirt. Additionally, it has to cover the entire room, and the path decision is made randomly.

## Usage Instructions

This branch does not use any framework to facilitate the creation of the code and its usage. Some things need to be done manually.

The compilation is done using the `javac` command with the following:

``javac src/ROOMBA_GUI/AspiradorLogica.java``

This command will generate several `.class` files inside the code. There are ways to avoid generating these files within the folder.

To run the code, use:

``java src.ROOMBA_GUI.AspiradorLogica``

---

## 日本語の翻訳

これは、プログラミング I の授業（UEG CCET 情報システム 2019 年度のカリキュラム）で実施されたプロジェクトです。この活動の目的は、Java Swing を使用してランダムに散らばった汚れがある部屋を作成する Java スクリプトを作成することでした。部屋には「ロムバ」というロボットがいて、仮想空間内を動き回り、汚れを掃除します。ロボットが部屋のすべてのブロックを掃除すると、実行が終了します。

## 3年後に更新された理由

2021年にこのプロジェクトを作成したとき、GIT やバージョン管理についてあまり理解していませんでした。コードを正常に動作させるために多くの変更を加えたため、各変更ごとに別々のブランチを作成して手動でバージョン管理をしていました。

活動を完了した後、プロジェクトを GITHUB にアップロードしましたが、コードが正しく動作しないバージョンをアップロードしてしまいました。

4年後に問題を発見しました。元のソリューションを失っていたため、実行に支障をきたしていたバグを修正することにしました。

## これは検索アルゴリズムですか？

残念ながら、違います。このシステムは、汚れまでの最短経路を追うための検索アルゴリズムを使用していません。また、部屋全体を移動する必要があり、経路の選択はランダムに行われます。

## 使用方法

このブランチは、コードの作成や利用を簡素化するフレームワークを使用していません。いくつかの操作は手動で行う必要があります。

コンパイルは `javac` コマンドで行い、次のコマンドを使用します：

``javac src/ROOMBA_GUI/AspiradorLogica.java``

このコマンドは、コード内に複数の `.class` ファイルを生成します。これらのファイルがフォルダ内に生成されるのを防ぐ方法もあります。

コードを実行するには、次のコマンドを使用します：

``java src.ROOMBA_GUI.AspiradorLogica``
