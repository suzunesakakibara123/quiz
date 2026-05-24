【テーブル作成時のSQL文】
（4択問題）
CREATE TABLE quiz4 (
    id SERIAL PRIMARY KEY,
    question VARCHAR(255) NOT NULL,
    choice1 VARCHAR(255) NOT NULL,
    choice2 VARCHAR(255) NOT NULL,
    choice3 VARCHAR(255) NOT NULL,
    choice4 VARCHAR(255) NOT NULL,
    answer INTEGER NOT NULL,
    explanation VARCHAR(255)
);


【クイズアプリの改修 ～実装前確認メモ～】

◆追加する機能要件：システムやソフトウェアが「何をするべきか」「ユーザーに何を提供するか」という具体的な機能や処理内容

①複数の2択問題を10個一括でPlayして、結果を表示する機能
 -ユーザー操作（UI）: 画面上の2択問題を10個まとめて回答するためのボタン、メニュー。
 -データ処理: 入力された回答データを基に行う回答結果の計算。
 -データ出力: 10問中何問正解したのかを表示する機能。

②4択問題を実装し、Playする機能
 -ユーザー操作（UI）: 画面上のクイズに回答するためのボタン、メニュー。
 -データ処理: CRUD機能で問題を作成、編集、削除、入力されたデータを基に行う回答結果の計算や処理。
 -データ出力: 4択問題をPlayすると１つの問題をランダムに表示。

③クイズをCSV経由でまとめて作成する機能
 -ユーザー操作（UI）: CSVのフォーマット経由でクイズの新規追加ができる入力フォーム、メニュー。
 -データ処理: 入力されたデータを基にクイズを登録する処理。
-データ出力: 正常に登録が完了したことを知らせる画面表示。

 ◆画面要件：システム開発においてユーザーとシステムが接する「画面」に求められる機能や仕様の定義・用意するべき画面の案

ーメニュー画面ー<br>
<img width="240" height="320" alt="image" src="https://github.com/user-attachments/assets/72d06599-9b56-4ef1-9386-a02ca8278631" />

ー2択メニューー<br>
<img width="240" height="320" alt="image" src="https://github.com/user-attachments/assets/6cbb67d1-f59d-4c55-89ab-6aee67f24c6c" />

ー4択メニューー<br>
<img width="240" height="320" alt="image" src="https://github.com/user-attachments/assets/c0e3d97b-3d15-4d6e-be97-cdd286cde615" />

ー2択問題を10個一括でPlayして、結果を表示する機能ー<br>
<img width="320" height="188" alt="image" src="https://github.com/user-attachments/assets/9739528f-8be5-43b5-bb26-1d6c733b6f0a" />

ー4択問題をPlayする機能ー<br>
<img width="320" height="200" alt="image" src="https://github.com/user-attachments/assets/3f638983-7b07-4ed7-8447-f1ae71ff7fed" />

ー4択問題を1問ずつ登録する機能ー<br>
<img width="254" height="320" alt="image" src="https://github.com/user-attachments/assets/fd5f1718-efab-4fe9-a433-39df9cc8de01" />

ークイズをCSV経由でまとめて作成する機能ー<br>　
<img width="258" height="320" alt="image" src="https://github.com/user-attachments/assets/b4d5c4fd-eced-42e7-8ab2-f073a160fd0d" />


◆各種設定予定URL

・2択問題を10問ランダムに出題する画面：menu/quiz2/play10

・10問の回答結果を表示する画面：menu/quiz2/result10

・4択問題の一覧を表示する画面：menu/quiz4

・4択問題を新規作成する画面：menu/quiz4/create

・4択問題を編集する画面：menu/quiz4/edit/{id}

・4択問題を削除する処理：menu/quiz4/delete/{id}

・4択問題を1問ランダムに出題する画面：menu/quiz4/play

・4択問題の正解・不正解を表示する画面：menu/quiz4/result

・CSVファイルから2択問題をまとめて登録する画面：menu/quiz2/csv-upload

・CSVファイルから4択問題をまとめて登録する画面：menu/quiz4/csv-upload
 
