クイズアプリの改修 ～実装前確認メモ～

◆追加する機能要件：システムやソフトウェアが「何をするべきか」「ユーザーに何を提供するか」という具体的な機能や処理内容

①複数の2択問題を10個一括でPlayして、結果を表示する機能
 -ユーザー操作（UI）: 画面上の2択問題を10個まとめて回答するためのボタン、メニュー。
 -データ処理: 入力された回答データを基に行う回答結果の計算。
 -データ出力: 10問中何問正解したのかを表示する機能。

②4択問題を実装し、Playする機能
 -ユーザー操作（UI）: 画面上のクイズに回答するためのボタン、メニュー。
 -データ処理: CRUD機能で問題を作成、編集、削除、入力されたデータを基に行う回答結果の計算や処理。
 -データ出力: 4択問題をPlayすると１つの問題をランダムに表示、データのエクスポート。

③クイズをCSV経由でまとめて作成する機能
 -ユーザー操作（UI）: CSVのフォーマット経由でクイズの新規追加ができる入力フォーム、メニュー。
 -データ処理: 入力されたデータを基にクイズを登録する処理。
-データ出力: 正常に登録が完了したことを知らせる画面表示、データのエクスポート。

 ◆画面要件：システム開発においてユーザーとシステムが接する「画面」に求められる機能や仕様の定義・用意するべき画面の案

ーメニュー画面ー<br>
<img width="252" height="320" alt="image" src="https://github.com/user-attachments/assets/32b02145-801a-44a9-86a3-a5e4de98d602" />

ー2択問題を10個一括でPlayして、結果を表示する機能ー<br>
<img width="320" height="188" alt="image" src="https://github.com/user-attachments/assets/9739528f-8be5-43b5-bb26-1d6c733b6f0a" />

ー4択問題をPlayする機能ー<br>
<img width="320" height="200" alt="image" src="https://github.com/user-attachments/assets/3f638983-7b07-4ed7-8447-f1ae71ff7fed" />

ー4択問題を1問ずつ登録する機能ー<br>
<img width="254" height="320" alt="image" src="https://github.com/user-attachments/assets/fd5f1718-efab-4fe9-a433-39df9cc8de01" />

ークイズをCSV経由でまとめて作成する機能ー<br>　
<img width="258" height="320" alt="image" src="https://github.com/user-attachments/assets/b4d5c4fd-eced-42e7-8ab2-f073a160fd0d" />


◆各種設定予定URL

・2択問題を10問ランダムに出題する画面：/quiz/play10

・10問の回答結果を表示する画面：/quiz/result10

・4択問題の一覧を表示する画面：/quiz4

・4択問題を新規作成する画面：/quiz4/create

・4択問題を編集する画面：/quiz4/edit/{id}

・4択問題を削除する処理：/quiz4/delete/{id}

・4択問題を1問ランダムに出題する画面：/quiz4/play

・4択問題の正解・不正解を表示する画面：/quiz4/result

・CSVファイルから4択問題をまとめて登録する画面：/quiz4/csv-upload
 
